package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Configuration
public class SecurityConfiguration {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(UserService userService) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	 @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
            configurer->configurer
                    .anyRequest().authenticated()
        ).formLogin(
                form->form.loginPage("/login")
                          .loginProcessingUrl("/authenticateTheUser").successHandler(successHandler())
                          .permitAll()
        ).logout(
                logout->logout.permitAll()
        );

        return http.build();
    }
	 	@Bean
	    public SimpleUrlAuthenticationSuccessHandler successHandler() {
	        return new SimpleUrlAuthenticationSuccessHandler() {
	            @Override
	            protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
	                String targetUrl = (String) request.getSession().getAttribute("url_prior_login");
	                if (targetUrl != null) {
	                    return targetUrl;
	                }
	                return super.determineTargetUrl(request, response);
	            }
	        };
	    }
	
}
