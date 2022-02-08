package com.sezo.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/api/*")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
	    .loginPage("/login")
	    .permitAll()
	    .and()
	    .logout()
	    .permitAll();
	}
	
       @Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	// Password=123
		String passwordEncripted = "$2a$12$/2c7J4nLPovNuYiL6soID.CRDqIiSURy384HXtNpulfMA580Nz26e"; 
		
		auth.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder())
		.withUser("sezayir")
		.password(passwordEncripted)
		.roles("USER");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
