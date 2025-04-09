package com.pedroituassu.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("projects")
public class Project {

    @Id
    private String id;
    private String name;
    private String url;
    private Date date;
    private List<String> technologies;
    private List<String> description;

    public Project(String id, String name, String url, Date date, List<String> technologies, List<String> description) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
        this.date = date;
        this.technologies = technologies;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl(String url) {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
