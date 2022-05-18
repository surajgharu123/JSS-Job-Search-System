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
@Order(2)
public class SecurityConfigurationForJobseeker extends WebSecurityConfigurerAdapter {


	@Autowired
	@Qualifier("UserDetailsServiceForJobseeker")
	UserDetailsService userDetailsServiceForJobseeker;
	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception { // Used for Authentication
		auth.userDetailsService(userDetailsServiceForJobseeker);
	
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception { // Used for authorization
		http.csrf().disable().authorizeRequests().antMatchers("/jss/user/job/authenticate").permitAll().and().formLogin();
	}

	

	@Bean(name = "authenticationManagerForJobseeker")
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return super.userDetailsService();

	}

	
}


//@EnableWebSecurity
//@Order(1)
//public class SecurityConfig_1 extends WebSecurityConfigurerAdapter {
//configure(authBuilder) {
//authBuilder.userService(UserDetailsServiceImpl_1);
//}
//configure(httpSecurity) {
//("/jobseeker/login")
//}
//}
//
//
//
//@EnableWebSecurity
//@Order(2)
//public class SecurityConfig_2 extends WebSecurityConfigurerAdapter {
//configure(authBuilder) {
//authBuilder.userService(UserDetailsServiceImpl_2);
//}
//configure(httpSecurity) {
//("/employee/login")
//}
//}
