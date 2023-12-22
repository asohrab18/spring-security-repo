package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("my-account")
	public String sayWelcome() {
		return "Welcome to My Bank Account!";
	}
}
