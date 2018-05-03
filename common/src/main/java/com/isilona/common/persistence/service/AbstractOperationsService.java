package com.isilona.common.persistence.service;


import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.isilona.common.persistence.ServicePreconditions;
import com.isilona.common.persistence.model.IEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class AbstractOperationsService<T extends IEntity> implements IOperationsService<T> {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    public AbstractOperationsService() {
        super();
    }

    // API

    // find - one

    @Override
    @Transactional(readOnly = true)
    public T findOne(final long id) {
        return getDao().findOne(id);
    }

    // find - all

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder) {
        final Sort sortInfo = constructSort(sortBy, sortOrder);
        return getDao().findAll(new PageRequest(page, size, sortInfo));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAllPaginated(final int page, final int size) {
        return getDao().findAll(new PageRequest(page, size));
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllSorted(final String sortBy, final String sortOrder) {
        final Sort sortInfo = constructSort(sortBy, sortOrder);
        return Lists.newArrayList(getDao().findAll(sortInfo));
    }

    // save/create/persist

    @Override
    public T create(final T entity) {
        Preconditions.checkNotNull(entity);

        final T persistedEntity = getDao().save(entity);

        return persistedEntity;
    }

    // update/merge

    @Override
    public void update(final T entity) {
        Preconditions.checkNotNull(entity);

        getDao().save(entity);
    }

    // delete

    @Override
    public void deleteAll() {
        getDao().deleteAll();
    }

    @Override
    public void delete(final long id) {
        final T entity = getDao().findOne(id);
        ServicePreconditions.checkEntityExists(entity);

        getDao().delete(entity);
    }

    // count

    @Override
    public long count() {
        return getDao().count();
    }

    // template method

    protected abstract PagingAndSortingRepository<T, Long> getDao();

    // template

    protected final Sort constructSort(final String sortBy, final String sortOrder) {
        Sort sortInfo = null;
        if (sortBy != null) {
            sortInfo = new Sort(Direction.fromString(sortOrder), sortBy);
        }
        return sortInfo;
    }

}