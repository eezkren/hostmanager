package com.isilona.restapi.persistence.model;

import com.isilona.common.persistence.model.INameableEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
public class Privilege implements INameableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRIV_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = false, nullable = true)
    private String description;

    public Privilege() {
        super();
    }

    public Privilege(final String nameToSet) {
        super();
        name = nameToSet;
    }

    // API

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

    public String getDescription() {
        return description;
    }

    public void setDescription(final String descriptionToSet) {
        description = descriptionToSet;
    }

    //


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege = (Privilege) o;

        return new EqualsBuilder()
                .append(id, privilege.id)
                .append(name, privilege.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return getName();
    }

}
