package com.isilona.restapi.persistence.dao;

import com.isilona.restapi.persistence.model.Role;
import com.isilona.common.interfaces.IByNameApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleJpaDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>, IByNameApi<Role> {
    //
}
