package com.easybytes.springsecuritylevel1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
}
