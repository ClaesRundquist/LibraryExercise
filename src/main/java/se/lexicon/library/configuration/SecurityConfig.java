package se.lexicon.library.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * https://stackoverflow.com/questions/35890540/when-to-use-spring-securitys-antmatcher
 * 
 */


@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.inMemoryAuthentication()
        	.withUser("user").password("{noop}pw").roles("USER", "ADMIN");

	}
	
	
	
  @Configuration
  @Order(1)                                                       
  public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
      protected void configure(HttpSecurity http) throws Exception {
          http
          	.antMatcher("/api/**")                              
          	.authorizeRequests()
              .anyRequest().hasRole("ADMIN")
              .and()
          .httpBasic();
      }
  }    

  @Configuration
  @Order(2) 
  public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

      @Override
      protected void configure(HttpSecurity http) throws Exception {
  		http
		.authorizeRequests()
			.antMatchers("/css/**", "/home").permitAll()		
			.antMatchers("/book/**", "/member/**", "/loan/**").hasRole("ADMIN")		
			.and()
		.formLogin()
			.loginPage("/login").failureUrl("/login-error");	
      }
  }
}