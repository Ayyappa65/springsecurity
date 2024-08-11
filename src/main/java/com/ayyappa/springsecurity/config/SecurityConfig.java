package com.ayyappa.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http
				.csrf(Customizer -> Customizer.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session ->
				      session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();	
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user1 = User.builder().username("harsh").password("{noop}h@123").roles("USER","MANAGER").build();
		
		UserDetails user2 = User.builder().username("kiran").password("{noop}k@123").roles("USER").build();
		
		
		
		return new InMemoryUserDetailsManager(user1,user2);
	}

}
