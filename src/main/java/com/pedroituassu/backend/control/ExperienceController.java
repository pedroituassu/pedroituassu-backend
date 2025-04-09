package com.pedroituassu.backend.control;

import com.pedroituassu.backend.model.Experience;
import com.pedroituassu.backend.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ExperienceController {

    @Autowired
    private ExperienceRepository experienceRepository;

    @PostMapping("/experience")
    public Experience addExperience(@RequestBody Experience experience) {
        return experienceRepository.save(experience);
    }

    @GetMapping("/experience")
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @GetMapping("/experience/{enterprise}")
    public Experience getExperienceByEnterprise(@PathVariable("enterprise") String enterprise) {
        return experienceRepository.findByEnterprise(enterprise);
    }

    @DeleteMapping("/experience/{enterprise}")
    public void deleteExperience(@PathVariable("enterprise") String enterprise) {
        experienceRepository.deleteByEnterprise(enterprise);
    }

    @PutMapping("/experience/{enterprise}/role")
    public void updateRole(@PathVariable String enterprise, @RequestBody String role) {
        experienceRepository.updateRole(enterprise, role);
    }

    @PutMapping("/experience/{enterprise}/endDate")
    public void updateEndDate(@PathVariable String enterprise, @RequestBody(required = false) Date endDate) {
        experienceRepository.updateEndDate(enterprise, endDate);
    }

    @PutMapping("/experience/{enterprise}/description")
    public void updateDescription(@PathVariable String enterprise, @RequestBody List<String> description) {
        experienceRepository.updateDescription(enterprise, description);
    }
}
