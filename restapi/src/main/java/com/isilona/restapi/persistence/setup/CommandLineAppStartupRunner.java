package com.isilona.restapi.persistence.setup;


import com.isilona.restapi.persistence.model.Host;
import com.isilona.restapi.service.IHostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Autowired
    private IHostService hostService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.", Arrays.toString(args));


        logger.info("Executing Setup");

        createHostRecords();

        logger.info("Setup Done");
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