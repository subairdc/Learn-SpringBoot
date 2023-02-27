package com.subairdc.springsecuritydemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.subairdc.springsecuritydemo.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity //we can specify the page access to the role based
public class SecurityConfiguration {
	
	@Autowired
    private JwtAuthFilter authFilter;
	
	@Bean //authentication
	public UserDetailsService userDetailsService() {
		//HardCode Method //Paramter -> PasswordEncoder encoder
//		UserDetails admin = User.withUsername("subair")
//				.password(encoder.encode("1234"))
//				.roles("ADMIN")
//				.build();
//		
//		UserDetails user = User.withUsername("mohamed")
//				.password(encoder.encode("0000"))
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(admin, user);
		
		return new UserInfoUserDetailsService();
	}
	
	@Bean //authorization
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/products/welcome", "/products/addNewUser", "/users/addNewUser", "/auth/authenticate").permitAll()
				.and()
				.authorizeHttpRequests()
				.requestMatchers("/products/**").authenticated()
				//.and().formLogin().and().build();
				.and()
				.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
	}
	
	@Bean // AuthenticationProvider for DB JPA
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
