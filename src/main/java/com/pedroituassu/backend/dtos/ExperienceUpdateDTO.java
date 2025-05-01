package com.pedroituassu.backend.dtos;

import com.pedroituassu.backend.model.Role;
import java.util.List;

public class ExperienceUpdateDTO {

    private String enterprise;
    private List<Role> roles;
    
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
