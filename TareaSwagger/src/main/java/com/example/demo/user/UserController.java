package com.example.demo.user;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

import com.example.demo.project.Project;

@RequestMapping("/user")
@RestController
public class UserController {
	private List<User> users = new ArrayList<>();
	
	@GetMapping
	public List<User> getAllProjects()
	{
		return users;
	}
	
	@PostMapping("/users")
    public User createProject(@RequestBody User user) {
        users.add(user);
        return user;
    }
	
	@GetMapping("/user/{id}")
	public User getProject(@PathVariable String  id)
	{
		for(User user : users)
			if(user.getId().equals(id))
				return user;
		return null;
	}
	
	@PutMapping("/{id}")
	public User putProject(@PathVariable("id") Long id, @RequestBody Project user)
	{
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable("id") Long id)
	{
		for(User user : users)
			if(user.getId().equals(id))
				users.remove(user);
	}
}
