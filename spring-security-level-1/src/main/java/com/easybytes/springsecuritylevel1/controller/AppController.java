package com.easybytes.springsecuritylevel1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("contact")
	public String contactBank() {
		return "Please Contact here with the bank.";
	}

	@GetMapping("notice")
	public String showNotices() {
		return "There are the notices from bank.";
	}
	
	@GetMapping("account")
	public String showAccountDetails() {
		return "This is my account information.";
	}
	
	@GetMapping("balance")
	public String showBalance() {
		return "This is the balance in my account.";
	}
}
