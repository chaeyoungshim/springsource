package com.study.board.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.study.board.handler.CustomAccessDeniedHandler;
import com.study.board.handler.CustomLoginSuccessHandler;
import com.study.board.service.CustomUserDetailService;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) //서블릿에다 했는데 여기서는 서블릿을 사용 안해서 여기다가
@EnableWebSecurity // 스프링 mvc + security 결합을 해줌 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	
	
	@Bean //<bean id="encoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/> 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean // <bean id="customLoginSuccessHandler" class="com.study.handler.CustomLoginSuccessHandler"/>
	public AuthenticationSuccessHandler customLoginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean // <bean id="customAccessDeniedHandler" class="com.study.handler.CustomAccessDeniedHandler"/>
	public AccessDeniedHandler customAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean // <bean id="customUserDetailService" class="com.study.service.CustomUserDetailService"/>
	public UserDetailsService customUserDetailService() {
		return new CustomUserDetailService();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	
	
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService())
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);
		
		
		http.formLogin()
			.loginPage("/member/login")
			.loginProcessingUrl("/login")
			.successHandler(customLoginSuccessHandler())
			.failureUrl("/member/login-error");
		
		http.logout()
			.logoutUrl("/member/logout")
			.invalidateHttpSession(true)
			.logoutSuccessUrl("/");
		
		http.rememberMe()
			.tokenRepository(persistentTokenRepository())
			.tokenValiditySeconds(604800);
		
	}
	
	
}
























