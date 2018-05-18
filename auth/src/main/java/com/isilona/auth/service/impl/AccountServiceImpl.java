package com.isilona.auth.service.impl;

import com.google.common.base.Preconditions;
import com.isilona.auth.dao.IAccountJpaDao;
import com.isilona.auth.model.Account;
import com.isilona.auth.service.IAccountService;
import com.isilona.common.persistence.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl extends AbstractService<Account> implements IAccountService, UserDetailsService {

    @Autowired
    private IAccountJpaDao dao;

    public AccountServiceImpl() {
        super();
    }

    // API

    // find

    @Override
    @Transactional(readOnly = true)
    public Account findByName(final String name) {
        return dao.findByName(name);
    }

    // Spring

    @Override
    protected final IAccountJpaDao getDao() {
        return dao;
    }

    /**
     * Loads the user from the datastore, by it's user name <br>
     */
    @Override
    public final UserDetails loadUserByUsername(final String username) {
        Preconditions.checkNotNull(username);

        final Account user = findByName(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Username was not found: " + username);
        }
    }
}

