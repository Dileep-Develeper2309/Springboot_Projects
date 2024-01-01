package com.dileep.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/employees")
	public String employees() {
		return "employees";
	}
	
	@GetMapping("/department")
	public String department() {
		return "department";
	}
}
