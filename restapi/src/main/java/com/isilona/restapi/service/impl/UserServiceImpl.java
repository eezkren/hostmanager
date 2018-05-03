package com.isilona.restapi.service.impl;

import com.isilona.common.persistence.service.AbstractService;
import com.isilona.restapi.persistence.dao.IUserJpaDao;
import com.isilona.restapi.persistence.model.User;
import com.isilona.restapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    @Autowired
    private IUserJpaDao dao;

    public UserServiceImpl() {
        super();
    }

    // API

    // find

    @Override
    @Transactional(readOnly = true)
    public User findByName(final String name) {
        return dao.findByName(name);
    }

    // other

    // Spring

    @Override
    protected final IUserJpaDao getDao() {
        return dao;
    }

}
