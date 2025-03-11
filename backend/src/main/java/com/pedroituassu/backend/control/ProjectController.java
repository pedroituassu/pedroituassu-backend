package com.pedroituassu.backend.control;

import com.pedroituassu.backend.model.Project;
import com.pedroituassu.backend.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/project")
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @GetMapping("/project")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/project/{name}")
    public Project getProjectByName(@PathVariable String name) {
        return projectRepository.findByName(name);
    }

    @DeleteMapping("/project/{name}")
    public void deleteProject(@PathVariable String name) {
        projectRepository.deleteByName(name);
    }

    @PutMapping("/project/{name}/name")
    public void updateName(@PathVariable String name, @RequestBody String updatedName) {
        projectRepository.updateName(name, updatedName);
    }

    @PutMapping("/project/{name}/url")
    public void updateUrl(@PathVariable String name, @RequestBody String url) {
        projectRepository.updateUrl(name, url);
    }

    @PutMapping("/project/{name}/tech")
    public void updateTechnologies(@PathVariable String name, @RequestBody List<String> technologies) {
        projectRepository.updateTechnologies(name, technologies);
    }

    @PutMapping("/project/{name}/date")
    public void updateDate(@PathVariable String name, @RequestBody Date date) {
        projectRepository.updateDate(name, date);
    }

    @PutMapping("/project/{name}/description")
    public void updateDescription(@PathVariable String name, @RequestBody List<String> description) {
        projectRepository.updateDescription(name, description);
    }
}
