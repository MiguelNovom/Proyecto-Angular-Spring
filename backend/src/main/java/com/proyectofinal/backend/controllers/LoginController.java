package com.proyectofinal.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.backend.entity.User;

@CrossOrigin()
@RestController
@RequestMapping({ "/users" })
public class LoginController {
	private List<User> users = createList();

	@GetMapping(produces = "application/json")
	public List<User> firstPage() {
		return users;
	}

	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {
		return new User("User successfully authenticated");
	}

	@DeleteMapping(path = { "/{id}" })
	public User delete(@PathVariable("id") int id) {
		User deletedEmp = null;
		for (User usr : users) {
			if (usr.getId().equals(id)) {
				users.remove(usr);
				deletedEmp = usr;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping
	public User create(@RequestBody User user) {
		users.add(user);
		return user;
	}
	private static List<User> createList() {
		List<User> tempEmployees = new ArrayList<>();
		return tempEmployees;
	}


}