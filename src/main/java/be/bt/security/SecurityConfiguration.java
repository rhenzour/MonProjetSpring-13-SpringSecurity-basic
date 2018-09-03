package be.bt.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	// Registe d'utilisateurs/roles, pour l'authentification
	// régler d'accés aux ressources (politique de sécurité)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
	 	// enable in memory based authentication with a user named
	 	// "user" and "admin"
	 	.inMemoryAuthentication().withUser("leila").password(encoder().encode("password")).roles("USER").
	 	and()
	 	
	 			.withUser("diddier").password("password").roles("USER", "ADMIN");

	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/public").permitAll().
		antMatchers("/secret").hasRole("ADMIN").and().httpBasic();
	
	}
	BCryptPasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
}
