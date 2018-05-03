package com.isilona.common.persistence.service;


import com.isilona.common.persistence.model.INameableEntity;

public abstract class AbstractService<T extends INameableEntity> extends AbstractOperationsService<T> implements IService<T> {

    public AbstractService() {
        super();
    }

    // API

}
