package com.jss.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//@Autowired
//PasswordEncoder passwordEncoder;
	@Autowired
	@Qualifier("JobSeekerAuthenticationManager")
	UserDetailsService userDetailsServiceForJobSeekerAuthenticationManager;
	
	@Autowired
	@Qualifier("EmployeeDetailsAuthenticationManager")
	UserDetailsService UserDetailsServiceEmployeeDetailsAuthenticationManager;
	
	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception { // Used for Authentication
		auth.userDetailsService(userDetailsServiceForJobSeekerAuthenticationManager);
		auth.userDetailsService(UserDetailsServiceEmployeeDetailsAuthenticationManager);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return super.userDetailsService();

	}

	@Override
	public void configure(HttpSecurity http) throws Exception { // Used for authorization
		http.csrf().disable().authorizeRequests().antMatchers("/user").hasAnyRole("USER", "ADMIN").antMatchers("/admin")
				.hasRole("ADMIN").antMatchers("/jss/user/authenticate").permitAll().and().formLogin();
	}
}
