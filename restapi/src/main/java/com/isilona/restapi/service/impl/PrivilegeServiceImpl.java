package com.isilona.restapi.service.impl;

import com.isilona.common.persistence.service.AbstractService;
import com.isilona.restapi.persistence.dao.IPrivilegeJpaDao;
import com.isilona.restapi.persistence.model.Privilege;
import com.isilona.restapi.service.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrivilegeServiceImpl extends AbstractService<Privilege> implements IPrivilegeService {

    @Autowired
    private IPrivilegeJpaDao dao;

    public PrivilegeServiceImpl() {
        super();
    }

    // API

    // find

    @Override
    public Privilege findByName(final String name) {
        return getDao().findByName(name);
    }

    // Spring

    @Override
    protected final IPrivilegeJpaDao getDao() {
        return dao;
    }

}
