package com.vinicoradi.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinicoradi.workshopmongo.domain.User;
import com.vinicoradi.workshopmongo.dto.UserDTO;
import com.vinicoradi.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource { 
	
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)  // or just @GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> list =  service.findAll();
		List<UserDTO> listDto = list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
	
		return ResponseEntity.ok().body(listDto);
		
	}
}
