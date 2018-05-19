package com.isilona.auth.service.impl;

import com.isilona.auth.dao.IRoleJpaDao;
import com.isilona.auth.model.Role;
import com.isilona.auth.service.IRoleService;
import com.isilona.common.persistence.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements IRoleService {

    @Autowired
    private IRoleJpaDao dao;

    public RoleServiceImpl() {
        super();
    }

    // API

    // get/find

    @Override
    public Role findByName(final String name) {
        return getDao().findByName(name);
    }

    // Spring

    @Override
    protected final IRoleJpaDao getDao() {
        return dao;
    }
}
