package com.pedroituassu.backend.control;

import com.pedroituassu.backend.dtos.ProjectUpdateDTO;
import com.pedroituassu.backend.model.Project;
import com.pedroituassu.backend.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{name}")
    public Project getProjectByName(@PathVariable String name) {
        return projectService.getProjectByName(name);
    }

    @DeleteMapping("/{name}")
    public void deleteProject(@PathVariable String name) {
        projectService.deleteProject(name);
    }

    @PatchMapping("/{name}")
    public ResponseEntity<Void> partialUpdateProject(
            @PathVariable String name,
            @RequestBody ProjectUpdateDTO updates
    ) {
        projectService.partialUpdateProject(name, updates);
        return ResponseEntity.ok().build();
    }
}
