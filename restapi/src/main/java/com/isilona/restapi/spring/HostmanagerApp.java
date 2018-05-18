package com.isilona.restapi.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ // @formatter:off
        HostmanagerContextConfig.class,
        HostmanagerPersistenceJpaConfig.class,
        HostmanagerServiceConfig.class,
        HostmanagerWebConfig.class,
        HostmanagerResourceConfig.class
}) // @formatter:on
public class HostmanagerApp extends SpringBootServletInitializer {

    public static void main(final String... args) {
        SpringApplication.run(HostmanagerApp.class, args);
    }

}
