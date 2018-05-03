package com.isilona.restapi.web.event;

import com.isilona.common.web.WebConstants;
import com.isilona.common.web.listeners.ResourceCreatedDiscoverabilityListener;
import org.springframework.stereotype.Component;


@Component
class SecResourceCreatedDiscoverabilityListener extends ResourceCreatedDiscoverabilityListener {

    public SecResourceCreatedDiscoverabilityListener() {
        super();
    }

    //

    @Override
    protected final String getBase() {
        return WebConstants.PATH_SEP;
    }

}
