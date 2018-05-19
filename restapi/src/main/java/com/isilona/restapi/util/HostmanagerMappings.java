package com.isilona.restapi.util;

public final class HostmanagerMappings {

    public static final String USERS = "users";
    public static final String PRIVILEGES = "privileges";
    public static final String ROLES = "roles";
    public static final String HOSTS = "hosts";

    private HostmanagerMappings() {
        throw new AssertionError();
    }

    public static final class Singular {

        public static final String USER = "user";
        public static final String PRIVILEGE = "privilege";
        public static final String ROLE = "role";
        public static final String HOST = "host";

        private Singular() {
            throw new IllegalStateException("Utility class");
        }

    }


    // API

}
