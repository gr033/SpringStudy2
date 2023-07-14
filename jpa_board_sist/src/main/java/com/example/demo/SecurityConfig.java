package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//위의 주소들만 로그인 하지 않고도 들어갈 수 있도록 설정
		//anyrequest => 나머지 요청들은 (authenticated) 로그인 해야 입장 가능
		http.authorizeHttpRequests()
		.requestMatchers("/", "/member/login","/member/join", "/board/list/**").permitAll()
		.requestMatchers("/admin/**").hasRole("admin")
		.anyRequest().authenticated();
		//로그인 했을 시 이동
		http.formLogin().loginPage("/member/login").permitAll()
		.defaultSuccessUrl("/board/list/1");
		//로그아웃 했을 시 이동
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/member/login");
		
		http.httpBasic();
		
		return http.build();
	}
}
