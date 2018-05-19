package com.isilona.restapi.persistence.model;

import com.google.common.base.MoreObjects;
import com.isilona.common.persistence.model.INameableEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Host implements INameableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HOST_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String ip;

    //

    public Host() {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        return Objects.equals(id, host.id) &&
                Objects.equals(name, host.name) &&
                Objects.equals(ip, host.ip);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, ip);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("ip", ip)
                .toString();
    }
}
