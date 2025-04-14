package com.pedroituassu.backend.service;

import com.pedroituassu.backend.dtos.ProjectUpdateDTO;
import com.pedroituassu.backend.model.Project;
import java.util.List;
import com.pedroituassu.backend.repositories.ProjectRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final MongoTemplate mongoTemplate;

    public ProjectService(ProjectRepository projectRepository, MongoTemplate mongoTemplate) {
        this.projectRepository = projectRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectByName(String name) {
        return projectRepository.findByName(name);
    }

    public void deleteProject(String name) {
        projectRepository.deleteByName(name);
    }

    public void partialUpdateProject(String name, ProjectUpdateDTO updates) {
        Query query = Query.query(Criteria.where("name").is(name));
        Update update = new Update();

        if (updates.getName() != null) update.set("name", updates.getName());
        if (updates.getUrl() != null) update.set("url", updates.getUrl());
        if (updates.getDate() != null) update.set("date", updates.getDate());
        if (updates.getTechnologies() != null) update.set("technologies", updates.getTechnologies());
        if (updates.getDescription() != null) update.set("description", updates.getDescription());

        mongoTemplate.updateFirst(query, update, Project.class);
    }
}
