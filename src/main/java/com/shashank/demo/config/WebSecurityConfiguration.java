package com.shashank.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {
	@Autowired
	private DataSource datasource;// provides database connection
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean 
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasRole("USER")
				)
		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/**").permitAll()
				.anyRequest().authenticated()
				)
		.formLogin(login -> login
				//.loginPage("/login")//yo rakheapxi chai manually login page panauna paryo and add that handler
				.defaultSuccessUrl("/welcome",true)
				//.usernameParameter("username")
				//.passwordParameter("password")
				.failureUrl("/login?failed").permitAll()
				)
		.logout(logout -> logout.logoutUrl("/logout")
				.logoutSuccessUrl("/home").permitAll()
				.invalidateHttpSession(true)
				);
        http.csrf(csrf -> csrf.disable());
		return http.build();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(datasource)
		.usersByUsernameQuery("select username,password,enable from user_detail where username=?")
		.authoritiesByUsernameQuery("select ud.username,ur.role_role from user_detail "
				+ "as ud, user_role as ur where ud.user_id=ur.user_id and ud.username=?");
	}
}
