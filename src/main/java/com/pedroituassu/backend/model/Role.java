package com.pedroituassu.backend.model;

import java.util.Date;
import java.util.List;

public class Role {

    private String name;
    private String location;
    private Date startDate;
    private Date endDate;
    private List<String> description;

    public Role(String name, String location, Date startDate, Date endDate, List<String> description) {
        this.name = name;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
