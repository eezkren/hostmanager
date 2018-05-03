package com.isilona.restapi.service.impl;

import com.isilona.common.persistence.service.AbstractService;
import com.isilona.restapi.persistence.dao.IHostJpaDao;
import com.isilona.restapi.persistence.model.Host;
import com.isilona.restapi.service.IHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HostServiceImpl extends AbstractService<Host> implements IHostService {

    @Autowired
    private IHostJpaDao dao;

    public HostServiceImpl() {
        super();
    }

    // API

    // find

    @Override
    @Transactional(readOnly = true)
    public Host findByName(final String name) {
        return dao.findByName(name);
    }

    // Spring

    @Override
    protected final IHostJpaDao getDao() {
        return dao;
    }

}
