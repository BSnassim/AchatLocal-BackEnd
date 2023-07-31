package com.example.AchatLocal.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
	
	@Autowired
	private JwtAuthenticationEntrypoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private PasswordEncoderCreation pwEN;

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		// configuring AuthenticationManager so that it knows from where to load
//		// choosing the password encoder to use
//		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(pwEN.myPasswordEncoder());
//	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable()
		.authorizeRequests().requestMatchers("/authenticate/**").permitAll().
		// restrict api's to certain roles
		requestMatchers("/administration/**").hasRole("Administrateur").
		// all requests besides login need to be authenticated
				anyRequest().authenticated().and().
				// exception handling
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
				// make sure we use stateless session; session won't be used to store user info
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// Adding a filter to validate the tokens with every request
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
