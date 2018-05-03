package com.isilona.common.persistence.service;

import com.isilona.common.interfaces.IByNameApi;
import com.isilona.common.persistence.model.INameableEntity;

public interface IService<T extends INameableEntity> extends IOperationsService<T>, IByNameApi<T> {

    //

}