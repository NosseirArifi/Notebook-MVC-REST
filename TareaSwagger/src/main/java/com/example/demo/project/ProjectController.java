package com.example.demo.project;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;



@RequestMapping("/projectos")
@RestController
public class ProjectController {

	private List<Project> projects = new ArrayList<>();
	
	@Operation(summary = "Muestra todos los proyectos", description ="Tiene que haber proyectos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Proyectos encontrados"),
			@ApiResponse(responseCode = "400",description = "Problema con la lista de proyect"),
			@ApiResponse(responseCode = "404",description = "Proyectos no encontrados",
				content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = ErrorProject.class))})
	})
	@GetMapping
	public List<Project> getAllProjects()
	{
		return projects;
	}
	
	@Operation(summary = "Subir proyecto ", description ="Proyecto valido")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Proyecto subido"),
			@ApiResponse(responseCode = "400",description = "Proyecto no valido")
	})
	@PostMapping("/projects")
    public Project createProject(@RequestBody Project project) {
        projects.add(project);
        return project;
    }
	
	
	@Operation(summary = "Obtener proyecto por id", description ="El proyecto tiene que existir")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Proyecto encontrado"),
			@ApiResponse(responseCode = "400",description = "Proyecto id no valido"),
			@ApiResponse(responseCode = "404",description = "Proyecto no encontrado",
				content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = ErrorProject.class))})
	})
	@GetMapping("/projects/{id}")
	public Project getProject(@PathVariable String  id)
	{
		for(Project project : projects)
			if(project.getId().equals(id))
				return project;
		return null;
	}
	
	@Operation(summary = "Actualizar proyecto por id", description ="El proyecto tiene que existir")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Proyecto actualizado"),
			@ApiResponse(responseCode = "400",description = "Proyecto id no valido"),
			@ApiResponse(responseCode = "404",description = "Proyecto no encontrado",
				content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = ErrorProject.class))})
	})
	@PutMapping("/{id}")
	public Project putProject(@PathVariable("id") Long id, @RequestBody Project project)
	{
		return null;
	}
	
	@Operation(summary = "Borrar proyecto por id", description ="El proyecto tiene que existir")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Proyecto borrado"),
			@ApiResponse(responseCode = "400",description = "Proyecto id no valido"),
			@ApiResponse(responseCode = "404",description = "Proyecto no encontrado",
				content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = ErrorProject.class))})
	})
	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable("id") Long id)
	{
		for(Project project : projects)
			if(project.getId().equals(id))
				projects.remove(project);
	}
}

