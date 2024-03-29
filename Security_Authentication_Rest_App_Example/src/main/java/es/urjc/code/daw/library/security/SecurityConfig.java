package es.urjc.code.daw.library.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration. In this class can be configured several aspects
 * related to security:
 * <ul>
 * <li>Security behavior: Login method, session management, CSRF, etc..</li>
 * <li>Authentication provider: Responsible to authenticate users. In this
 * example, we use an instance of UserRepositoryAuthProvider, that authenticate
 * users stored in a Spring Data database.</li>
 * <li>URL Access Authorization: Access to http URLs depending on Authenticated
 * vs anonymous users and also based on user role.</li>
 * </ul>
 * 
 * NOTE: The only part of this class intended for app developer customization is
 * the method <code>configureUrlAuthorization</code>. App developer should
 * decide what URLs are accessible by what user role.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthProvider userRepoAuthProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		configureUrlAuthorization(http);

		// Disable CSRF protection (it is difficult to implement with ng2)
		http.csrf().disable();

		// Use Http Basic Authentication
		// En aplicaciones Rest no hace falta configurar las url de redirección como login, error, etc. como en Web
		// De modo que tan solo le decimos a Spring que use el protocolo httpBasic
		http.httpBasic();

		// Do not redirect when logout
		// La forma que tenemos de decirle a Spring que no haga algo por defecto es diciéndole que no haga nada
		// De modo que cuando se haga un Logout no se redirigirá a ningún sitio, puesto que se trata de una api Rest
		http.logout().logoutSuccessHandler((rq, rs, a) -> {	});
	}

	private void configureUrlAuthorization(HttpSecurity http) throws Exception {

		// APP: This rules have to be changed by app developer

		// URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/books/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/books/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN");		

		// Other URLs can be accessed without authentication
		http.authorizeRequests().anyRequest().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Database authentication provider
		auth.authenticationProvider(userRepoAuthProvider);
	}
}