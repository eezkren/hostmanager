package com.isilona.restapi.persistence.setup;


import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.isilona.restapi.persistence.model.Host;
import com.isilona.restapi.persistence.model.Privilege;
import com.isilona.restapi.persistence.model.Role;
import com.isilona.restapi.persistence.model.User;
import com.isilona.restapi.service.IHostService;
import com.isilona.restapi.service.IPrivilegeService;
import com.isilona.restapi.service.IRoleService;
import com.isilona.restapi.service.IUserService;
import com.isilona.restapi.util.HostmanagerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPrivilegeService privilegeService;

    @Autowired
    private IHostService hostService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.", Arrays.toString(args));


        logger.info("Executing Setup");

        createPrivileges();
        createRoles();
        createUsers();
        createHostRecords();

        logger.info("Setup Done");
    }

    private void createPrivileges() {
        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.ROLE_HOST_RECORD_READ);
        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.ROLE_HOST_RECORD_WRITE);

        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.CAN_PRIVILEGE_READ);
        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.CAN_PRIVILEGE_WRITE);

        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.CAN_ROLE_READ);
        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.CAN_ROLE_WRITE);

        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.CAN_USER_READ);
        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.CAN_USER_WRITE);

        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.CAN_USER_READ);
        createPrivilegeIfNotExisting(HostmanagerConstants.Privileges.CAN_USER_WRITE);
    }

    final void createPrivilegeIfNotExisting(final String name) {
        final Privilege entityByName = privilegeService.findByName(name);
        if (entityByName == null) {
            final Privilege entity = new Privilege(name);
            privilegeService.create(entity);
        }
    }

    // Role

    private void createRoles() {
        final Privilege canHostRecordRead = privilegeService.findByName(HostmanagerConstants.Privileges.ROLE_HOST_RECORD_READ);
        final Privilege canHostRecordWrite = privilegeService.findByName(HostmanagerConstants.Privileges.ROLE_HOST_RECORD_WRITE);
        final Privilege canPrivilegeRead = privilegeService.findByName(HostmanagerConstants.Privileges.CAN_PRIVILEGE_READ);
        final Privilege canPrivilegeWrite = privilegeService.findByName(HostmanagerConstants.Privileges.CAN_PRIVILEGE_WRITE);
        final Privilege canRoleRead = privilegeService.findByName(HostmanagerConstants.Privileges.CAN_ROLE_READ);
        final Privilege canRoleWrite = privilegeService.findByName(HostmanagerConstants.Privileges.CAN_ROLE_WRITE);
        final Privilege canUserRead = privilegeService.findByName(HostmanagerConstants.Privileges.CAN_USER_READ);
        final Privilege canUserWrite = privilegeService.findByName(HostmanagerConstants.Privileges.CAN_USER_WRITE);

        Preconditions.checkNotNull(canPrivilegeRead);
        Preconditions.checkNotNull(canPrivilegeWrite);
        Preconditions.checkNotNull(canRoleRead);
        Preconditions.checkNotNull(canRoleWrite);
        Preconditions.checkNotNull(canUserRead);
        Preconditions.checkNotNull(canUserWrite);

        createRoleIfNotExisting(HostmanagerConstants.Roles.ROLE_USER, Sets.<Privilege>newHashSet(canUserRead, canRoleRead, canPrivilegeRead));
        createRoleIfNotExisting(HostmanagerConstants.Roles.ROLE_ADMIN, Sets.<Privilege>newHashSet(canUserRead, canUserWrite, canRoleRead, canRoleWrite, canPrivilegeRead, canPrivilegeWrite));
        createRoleIfNotExisting(HostmanagerConstants.Roles.ROLE_NURSE, Sets.<Privilege>newHashSet(canHostRecordRead));
        createRoleIfNotExisting(HostmanagerConstants.Roles.ROLE_DOCTOR, Sets.<Privilege>newHashSet(canHostRecordRead, canHostRecordWrite));

    }

    final void createRoleIfNotExisting(final String name, final Set<Privilege> privileges) {
        final Role entityByName = roleService.findByName(name);
        if (entityByName == null) {
            final Role entity = new Role(name);
            entity.setPrivileges(privileges);
            roleService.create(entity);
        }
    }

    // User/User

    final void createUsers() {
        final Role roleAdmin = roleService.findByName(HostmanagerConstants.Roles.ROLE_ADMIN);
        final Role roleUser = roleService.findByName(HostmanagerConstants.Roles.ROLE_USER);
        final Role roleDoctor = roleService.findByName(HostmanagerConstants.Roles.ROLE_DOCTOR);
        final Role roleNurse = roleService.findByName(HostmanagerConstants.Roles.ROLE_NURSE);

        createUserIfNotExisting(HostmanagerConstants.ADMIN_EMAIL, HostmanagerConstants.ADMIN_PASS, Sets.<Role>newHashSet(roleAdmin, roleDoctor));
        createUserIfNotExisting(HostmanagerConstants.USER_EMAIL, HostmanagerConstants.USER_PASS, Sets.<Role>newHashSet(roleUser, roleNurse));
    }

    final void createUserIfNotExisting(final String loginName, final String pass, final Set<Role> roles) {
        final User entityByName = userService.findByName(loginName);
        if (entityByName == null) {
            final User entity = new User(loginName, pass, roles);
            userService.create(entity);
        }
    }

    // host records
    public void createHostRecords() {
        createHostRecordIfNotexist("TEST", "192.168.0.1");
        createHostRecordIfNotexist("DEV", "192.168.0.2");
    }

    void createHostRecordIfNotexist(String name, String ip) {
        final Host entity = new Host();
        entity.setName(name);
        entity.setIp(ip);

        if (hostService.findByName(name) == null) {
            hostService.create(entity);
        }
    }
}