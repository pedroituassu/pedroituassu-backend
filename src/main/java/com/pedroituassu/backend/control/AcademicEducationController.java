package com.pedroituassu.backend.control;

import com.pedroituassu.backend.dtos.AcademicEducationUpdateDTO;
import com.pedroituassu.backend.model.AcademicEducation;
import com.pedroituassu.backend.service.AcademicEducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/academic_educations")
public class AcademicEducationController {

    private final AcademicEducationService academicEducationService;

    public AcademicEducationController(AcademicEducationService academicEducationService) {
        this.academicEducationService = academicEducationService;
    }

    @PostMapping
    public AcademicEducation addAcademicEducation(@RequestBody AcademicEducation academicEducation) {
        return academicEducationService.saveAcademicEducation(academicEducation);
    }

    @GetMapping
    public List<AcademicEducation> getAllAcademicEducations() {
        return academicEducationService.getAllAcademicEducations();
    }

    @GetMapping("/{title}")
    public AcademicEducation getAcademicEducationByTitle(@PathVariable String title) {
        return academicEducationService.getAcademicEducationByTitle(title);
    }

    @DeleteMapping("/{title}")
    public void deleteAcademicEducation(@PathVariable String title) {
        academicEducationService.deleteAcademicEducation(title);
    }

    @PatchMapping("/{title}")
    public ResponseEntity<Void> partialUpdateAcademicEducation(
            @PathVariable String title,
            @RequestBody AcademicEducationUpdateDTO updates
    ) {
        academicEducationService.partialUpdateAcademicEducation(title, updates);
        return ResponseEntity.ok().build();
    }
}
