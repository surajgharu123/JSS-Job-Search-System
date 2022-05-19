package com.jss.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Order(1)
public class SecurityConfigurationForEmployee extends WebSecurityConfigurerAdapter{


//@Autowired
//PasswordEncoder passwordEncoder;

	
	@Autowired
	@Qualifier("UserDetailsServiceForEmployee")
	UserDetailsService userDetailsServiceForEmployee;
	
	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception { // Used for Authentication
		
		auth.userDetailsService(userDetailsServiceForEmployee);
	}

	

	@Bean(name = "AuthenticationManagerForEmployee")
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return super.userDetailsService();

	}

	@Override
	public void configure(HttpSecurity http) throws Exception { // Used for authorization
		http.csrf().disable().authorizeRequests().antMatchers("/jss/user/").permitAll().
		antMatchers("/jss/user/employee/authenticate").
		permitAll().and().formLogin();
	}

}
