package com.mballem.curso.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/", "/home", "/webjars/**", "/css/**", "/image/**", "/js/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/", true)
			.failureUrl("/login-error")
			// .permitAll() Para que todo usuario tenha acesso a página de login e pagina de erro
			.permitAll()
		.and()
			// Por padrão ele vai redirecionar para a página de login ao realizar o logout, mas iremos redirecionar para a pagina raiz da aplicacao 
			.logout()
			.logoutSuccessUrl("/");
	}
}
