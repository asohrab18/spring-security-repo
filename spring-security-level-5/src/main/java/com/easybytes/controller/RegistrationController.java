package com.easybytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easybytes.entity.Customer;
import com.easybytes.repository.CustomerRepository;

@RestController
public class RegistrationController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
		ResponseEntity<String> responseEntity = null;
		Customer savedCustomer = null;
		try {
			String hashedPwd = passwordEncoder.encode(customer.getPwd());
			customer.setPwd(hashedPwd);
			savedCustomer = customerRepository.save(customer);
			if (savedCustomer.getId() > 0) {
				responseEntity = ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully.");
			}
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("an exception occurred due to " + e.getMessage());

		}
		return responseEntity;
	}
}
