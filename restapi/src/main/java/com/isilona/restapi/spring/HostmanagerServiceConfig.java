package com.isilona.restapi.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.isilona.restapi.service"})
public class HostmanagerServiceConfig {

    public HostmanagerServiceConfig() {
        super();
    }

    // beans

}
