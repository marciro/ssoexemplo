package br.org.mcr.ssoexemplo.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.azure.spring.autoconfigure.b2c.AADB2COidcLoginConfigurer;

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final AADB2COidcLoginConfigurer configurer;

	public WebSecurityConfiguration(AADB2COidcLoginConfigurer configurer) {
		this.configurer = configurer;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()//
			.anyRequest()//
			.authenticated()//
			.and()//
			.apply(configurer);

	}
}