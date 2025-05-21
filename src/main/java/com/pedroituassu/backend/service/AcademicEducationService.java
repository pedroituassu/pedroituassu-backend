package com.pedroituassu.backend.service;

import com.pedroituassu.backend.dtos.AcademicEducationUpdateDTO;
import com.pedroituassu.backend.model.AcademicEducation;
import java.util.List;
import com.pedroituassu.backend.repositories.AcademicEducationRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class AcademicEducationService {
    private final AcademicEducationRepository academicEducationRepository;
    private final MongoTemplate mongoTemplate;

    public AcademicEducationService(AcademicEducationRepository academicEducationRepository, MongoTemplate mongoTemplate) {
        this.academicEducationRepository = academicEducationRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public AcademicEducation saveAcademicEducation(AcademicEducation academicEducation) {
        return academicEducationRepository.save(academicEducation);
    }

    public List<AcademicEducation> getAllAcademicEducations() {
        return academicEducationRepository.findAll();
    }

    public AcademicEducation getAcademicEducationByTitle(String title) {
        return academicEducationRepository.findByTitle(title);
    }

    public void deleteAcademicEducation(String title) {
        academicEducationRepository.deleteByTitle(title);
    }

    public void partialUpdateAcademicEducation(String title, AcademicEducationUpdateDTO updates) {
        Query query = Query.query(Criteria.where("title").is(title));
        Update update = new Update();

        if (updates.getTitle() != null) update.set("title", updates.getTitle());
        if (updates.getInstitute() != null) update.set("institute", updates.getInstitute());
        if (updates.getStartDate() != null) update.set("startDate", updates.getStartDate());
        if (updates.getEndDate() != null) update.set("endDate", updates.getEndDate());
        if (updates.getLocation() != null) update.set("location", updates.getLocation());
        if (updates.getRoles() != null) update.set("roles", updates.getRoles());

        mongoTemplate.updateFirst(query, update, AcademicEducation.class);
    }
}
