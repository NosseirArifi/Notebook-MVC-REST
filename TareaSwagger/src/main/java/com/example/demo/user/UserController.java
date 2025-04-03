package com.example.demo.user;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

import com.example.demo.project.ErrorProject;
import com.example.demo.project.Project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/user")
@RestController
public class UserController {
	private List<User> users = new ArrayList<>();
	
	@Operation(summary = "Muestra todos los usuarios", description ="Tiene que haber usuarios")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Usuarios encontrados"),
			@ApiResponse(responseCode = "400",description = "Problema con la lista de usuarios"),
			@ApiResponse(responseCode = "404",description = "Usuarios no encontrados",
				content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = ErrorUser.class))})
	})
	@GetMapping
	public List<User> getAllProjects()
	{
		return users;
	}
	
	@Operation(summary = "Sube un usuario", description ="Tiene que ser un id valido")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Usuario subido"),
			@ApiResponse(responseCode = "500",description = "Problema con el servidor"),
			@ApiResponse(responseCode = "404",description = "Usuario no encontrados",
				content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = ErrorUser.class))})
	})
	@PostMapping("/users")
    public User createProject(@RequestBody User user) {
        users.add(user);
        return user;
    }
	
	@Operation(summary = "Muestra usuario segun id", description ="Tiene que ser un id valido")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Usuario encontrados"),
			@ApiResponse(responseCode = "400",description = "Problema con el id de usuario"),
			@ApiResponse(responseCode = "404",description = "Usuario no encontrados",
				content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = ErrorUser.class))})
	})
	@GetMapping("/user/{id}")
	public User getProject(@PathVariable String  id)
	{
		for(User user : users)
			if(user.getId().equals(id))
				return user;
		return null;
	}
	
	@Operation(summary = "Actualiza usuario por id", description ="Tiene que ser un id valido")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Usuario actualizado"),
			@ApiResponse(responseCode = "400",description = "Problema con la actualizacion de usuario"),
			@ApiResponse(responseCode = "404",description = "Usuario no encontrados",
				content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = ErrorUser.class))})
	})
	@PutMapping("/{id}")
	public User putProject(@PathVariable("id") Long id, @RequestBody Project user)
	{
		return null;
	}
	
	@Operation(summary = "Borra usuario por ID", description ="Tiene que ser un ID valido")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Usuarios encontrados"),
			@ApiResponse(responseCode = "400",description = "Problema con la lista de usuarios"),
			@ApiResponse(responseCode = "404",description = "Usuarios no encontrados",
				content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = ErrorUser.class))}),
			@ApiResponse(responseCode = "500", description = "Problemas con la comunicacion con el servidor")
	})
	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable("id") Long id)
	{
		for(User user : users)
			if(user.getId().equals(id))
				users.remove(user);
	}
}
