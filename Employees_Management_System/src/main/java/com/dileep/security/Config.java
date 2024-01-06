package com.dileep.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {

	//adding users and their roles
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails dileep = User.builder()
				.username("dileep")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails rohit = User.builder()
				.username("rohit")
				.password("{noop}test123")
				.roles("MANAGER")
				.build();
		
		UserDetails virat = User.builder()
				.username("virat")
				.password("{noop}test123")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(dileep,rohit,virat);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeHttpRequests(configurer -> 
		configurer
		.requestMatchers("/").permitAll()
		.requestMatchers("/manager").hasRole("MANAGER")
		.requestMatchers("/systems").hasRole("ADMIN")
		.requestMatchers("/home").permitAll()
		.requestMatchers("/contact").permitAll()
		.anyRequest().authenticated()
				)
		.formLogin(form ->
		form.loginPage("/")
		.loginProcessingUrl("/authenticateTheUser")
		.defaultSuccessUrl("/main", true)
		.permitAll()
		)
		.logout(logout -> logout.permitAll()
				)
		.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));
		return httpSecurity.build();
	}
}