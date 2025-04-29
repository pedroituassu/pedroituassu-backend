package com.pedroituassu.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

import com.pedroituassu.backend.model.Role;

@Document("experiences")
public class Experience {

    @Id
    private String id;
    private String enterprise;
    private List<Role> roles;

    public Experience(String enterprise, List<Role> roles) {
        super();
        this.enterprise = enterprise;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
