package com.example.demoswagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoswagger.model.Users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "user", description = "the user API")
@RestController
public class UserController {

	private List<Users> users = createList();
	
	@Operation(summary = "Find all users", description = "Returns list of users", tags = { "user" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public List<Users> firstPage() {
		return users;
	}

	@DeleteMapping(path = { "/{id}" })
	public Users delete(@PathVariable("id") int id) {
		Users deletedUsr = null;
		for (Users emp : users) {
			if (emp.getUserId().equals(id)) {
				users.remove(emp);
				deletedUsr = emp;
				break;
			}
		}
		return deletedUsr;
	}

	@PostMapping
	public Users create(@RequestBody Users user) {
		users.add(user);
		System.out.println(users);
		return user;
	}

	private static List<Users> createList() {
		List<Users> tempUsers = new ArrayList<>();
		Users emp1 = new Users();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setUserId("1");
		emp1.setPhoneNumber(400000000);

		Users emp2 = new Users();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp1.setUserId("2");
		emp1.setPhoneNumber(400000000);
		tempUsers.add(emp1);
		tempUsers.add(emp2);
		return tempUsers;
	}
}