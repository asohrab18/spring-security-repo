package com.easybytes.springsecuritylevel2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(requests -> requests.requestMatchers("account", "balance").authenticated()
			.requestMatchers("contact", "notice").permitAll())
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults());		
		return http.build();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		//Approach 1: Here, we save users credentials in application's memory.
		UserDetails user1 = User.withDefaultPasswordEncoder().username("user1").password("pass1").authorities("admin").build();

		UserDetails user2 = User.withDefaultPasswordEncoder().username("user2").password("pass2").authorities("read-write").build();

		UserDetails user3 = User.withDefaultPasswordEncoder().username("user3").password("pass3").authorities("read-only").build();

		return new InMemoryUserDetailsManager(user1, user2, user3);
	}
}
