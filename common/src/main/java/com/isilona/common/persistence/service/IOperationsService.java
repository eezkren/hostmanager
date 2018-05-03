package com.isilona.common.persistence.service;

import com.isilona.common.interfaces.IOperations;
import com.isilona.common.persistence.model.IEntity;


public interface IOperationsService<T extends IEntity> extends IOperations<T> {

}
