package com.easybytes.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.easybytes.entity.Customer;
import com.easybytes.repository.CustomerRepository;

@Service
public class EasyBankUserDetails implements UserDetailsService
{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName, password;
		List<GrantedAuthority> authorities;
		List<Customer> customers = customerRepository.findByEmail(username);
		if (customers == null || customers.isEmpty()) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		} else {
			userName = customers.get(0).getEmail();
			password = customers.get(0).getPwd();
			authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
		}
		return new User(userName, password, authorities);
	}
}
