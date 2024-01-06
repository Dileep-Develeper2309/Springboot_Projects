package com.dileep.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/")
	public String homepage() {
		return "homepage";
	}
	
	
	@GetMapping("/employees")
	public String employee() {
		return "employees";
	}
	
	
	@GetMapping("/manager")
	public String manager() {
		return "manager";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/systems")
	public String systems() {
		return "systems";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	
	//@GetMapping("/test")
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
}
