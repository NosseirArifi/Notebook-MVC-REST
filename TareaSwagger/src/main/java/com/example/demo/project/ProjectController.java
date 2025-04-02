package com.example.demo.project;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/projectos")
@RestController
public class ProjectController {

	private List<Project> projects = new ArrayList<>();
	
	@GetMapping
	public List<Project> getAllProjects()
	{
		return projects;
	}
	
	@PostMapping("/projects")
    public Project createProject(@RequestBody Project project) {
        projects.add(project);
        return project;
    }
	
	@GetMapping("/projects/{id}")
	public Project getProject(@PathVariable String  id)
	{
		for(Project project : projects)
			if(project.getId().equals(id))
				return project;
		return null;
	}
	
	@PutMapping("/{id}")
	public Project putProject(@PathVariable("id") Long id, @RequestBody Project project)
	{
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable("id") Long id)
	{
		for(Project project : projects)
			if(project.getId().equals(id))
				projects.remove(project);
	}
}

