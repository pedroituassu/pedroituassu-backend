package com.pedroituassu.backend.service;

import com.pedroituassu.backend.dtos.ExperienceUpdateDTO;
import com.pedroituassu.backend.model.Experience;
import java.util.List;
import com.pedroituassu.backend.repositories.ExperienceRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final MongoTemplate mongoTemplate;

    public ExperienceService(ExperienceRepository experienceRepository, MongoTemplate mongoTemplate) {
        this.experienceRepository = experienceRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public Experience getExperienceByEnterprise(String enterprise) {
        return experienceRepository.findByEnterprise(enterprise);
    }

    public void deleteExperience(String enterprise) {
        experienceRepository.deleteByEnterprise(enterprise);
    }

    public void partialUpdateExperience(String enterprise, ExperienceUpdateDTO updates) {
        Query query = Query.query(Criteria.where("enterprise").is(enterprise));
        Update update = new Update();

        if (updates.getEnterprise() != null) update.set("enterprise", updates.getEnterprise());
        if (updates.getRole() != null) update.set("role", updates.getRole());
        if (updates.getStartDate() != null) update.set("startDate", updates.getStartDate());
        if (updates.getEndDate() != null) update.set("endDate", updates.getEndDate());
        if (updates.getLocation() != null) update.set("location", updates.getLocation());
        if (updates.getDescription() != null) update.set("description", updates.getDescription());

        mongoTemplate.updateFirst(query, update, Experience.class);
    }
}
