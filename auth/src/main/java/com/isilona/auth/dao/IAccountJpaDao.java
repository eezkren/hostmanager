package com.isilona.auth.dao;

import com.isilona.auth.model.Account;
import com.isilona.common.interfaces.IByNameApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountJpaDao extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account>, IByNameApi<Account> {
    //
}