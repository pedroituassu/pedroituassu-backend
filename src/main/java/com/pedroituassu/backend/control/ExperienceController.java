package com.pedroituassu.backend.control;

import com.pedroituassu.backend.dtos.ExperienceUpdateDTO;
import com.pedroituassu.backend.model.Experience;
import com.pedroituassu.backend.service.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping
    public Experience addExperience(@RequestBody Experience experience) {
        return experienceService.saveExperience(experience);
    }

    @GetMapping
    public List<Experience> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    @GetMapping("/{enterprise}")
    public Experience getExperienceByEnterprise(@PathVariable String enterprise) {
        return experienceService.getExperienceByEnterprise(enterprise);
    }

    @DeleteMapping("/{enterprise}")
    public void deleteExperience(@PathVariable String enterprise) {
        experienceService.deleteExperience(enterprise);
    }

    @PatchMapping("/{enterprise}")
    public ResponseEntity<Void> partialUpdateExperience(
            @PathVariable String enterprise,
            @RequestBody ExperienceUpdateDTO updates
    ) {
        experienceService.partialUpdateExperience(enterprise, updates);
        return ResponseEntity.ok().build();
    }
}
