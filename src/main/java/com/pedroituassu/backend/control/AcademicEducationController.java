package com.pedroituassu.backend.control;


import com.pedroituassu.backend.model.AcademicEducation;
import com.pedroituassu.backend.repositories.AcademicEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AcademicEducationController {

    @Autowired
    AcademicEducationRepository academicEducationRepository;

    @PostMapping("/academic")
    public AcademicEducation addAcademicEducation(@RequestBody AcademicEducation academicEducation) {
        return academicEducationRepository.save(academicEducation);
    }

    @GetMapping("/academic")
    public List<AcademicEducation> getAllAcademicEducations() {
        return academicEducationRepository.findAll();
    }

    @GetMapping("/academic/{title}")
    public AcademicEducation getAcademicAcademicEducation(@PathVariable String title) {
        return academicEducationRepository.findByTitle(title);
    }

    @DeleteMapping("/academic/{title}")
    public void deleteAcademicEducation(@PathVariable String title) {
        academicEducationRepository.deleteByTitle(title);
    }

    @PutMapping("/academic/{title}/endDate")
    public void updateEndDate(@PathVariable String title, @RequestBody Date endDate) {
        academicEducationRepository.updateEndDate(title, endDate);
    }
}
