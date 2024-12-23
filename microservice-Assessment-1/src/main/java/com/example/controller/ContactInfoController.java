package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pojo.AuthRequest;
import com.example.entity.ContactInfo;
import com.example.service.ContactInfoService;
import com.example.serviceimpl.JwtService;
@RestController
@RequestMapping("/contact")
@CrossOrigin
public class ContactInfoController {
	@Autowired
	private ContactInfoService service;
	@Autowired
	private AuthenticationManager authenticationManager;
		
	@PostMapping("/new")
	public ResponseEntity<String> addNewUser(@RequestBody ContactInfo contactInfo){
		return new ResponseEntity<String> (service.addContact(contactInfo), HttpStatus.CREATED);
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
		return JwtService.generateToken(authRequest.getUsername());
		}else {
			throw new UsernameNotFoundException("Invalid User");
		}
	}
}
	