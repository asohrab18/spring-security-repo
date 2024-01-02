package com.easybytes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easybytes.entity.Loans;
import com.easybytes.repository.LoanRepository;

@RestController
public class LoansController {

	@Autowired
	private LoanRepository loanRepository;

	@GetMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestParam int id) {
		List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
		if (loans != null) {
			return loans;
		} else {
			return null;
		}
	}

}