package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

	@GetMapping("my-cards")
	public String sayWelcome() {
		return "Welcome to My Bank Cards!";
	}
}
