package com.isilona.auth.model;

import com.isilona.common.persistence.model.INameableEntity;

import javax.persistence.*;

@MappedSuperclass
public class NamedBaseEntity implements INameableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(unique = true, nullable = false)
    protected String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long idToSet) {
        id = idToSet;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(final String nameToSet) {
        name = nameToSet;
    }
}
