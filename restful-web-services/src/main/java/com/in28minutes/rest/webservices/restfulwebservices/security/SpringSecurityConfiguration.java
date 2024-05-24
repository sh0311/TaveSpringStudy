package com.in28minutes.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
	//	1)모든 요청이 authenticated 되어야 함
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated()
				);
	//	2)요청이 authenticate 되지 않았다면 로그인 웹페이지가 아닌 팝업창 뜨게
		http.httpBasic(withDefaults());
		
	//	3)CSRF 해제해서 Post, Put 가능하게
		http.csrf().disable();
		
		
		return http.build();
	}
}
