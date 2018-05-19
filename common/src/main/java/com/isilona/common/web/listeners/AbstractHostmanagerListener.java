package com.isilona.common.web.listeners;

import com.google.common.base.Preconditions;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public abstract class AbstractHostmanagerListener<E extends ApplicationEvent> implements ApplicationListener<E> {

    public AbstractHostmanagerListener() {
        super();
    }

    //

    @Override
    public final void onApplicationEvent(E ev) {
        Preconditions.checkNotNull(ev);

        addLinkHeader(ev);
    }

    protected abstract void addLinkHeader(E ev);
}
