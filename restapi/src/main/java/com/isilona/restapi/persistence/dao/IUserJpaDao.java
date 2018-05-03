package com.isilona.restapi.persistence.dao;

import com.isilona.restapi.persistence.model.User;
import com.isilona.common.interfaces.IByNameApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserJpaDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, IByNameApi<User> {
    //
}
