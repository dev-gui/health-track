package br.com.fiap.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@SuppressWarnings("deprecation")
@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	


	
	@Autowired
	DataSource dataSource;

	private static final String[] PUBLICO = {
			"/",
			"/cadastrar/**",
			"/assets/**",
			"/css/**",
			"/dist/**",
			"/imagens/**",
			"/js/**",
			"/h2/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//            http.headers().frameOptions().disable();
		
		http.cors().and().csrf().disable();
		http.authorizeRequests().antMatchers(PUBLICO).permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
        .loginPage("/")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/dashboard", true)
//        .failureUrl("/login.html?error=true")
		.permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .permitAll();
	}
	
	
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select email, senha, 'true' from usuario where email=?")
			.authoritiesByUsernameQuery("select email, perfil from usuario where email=?")
			.passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

	@Bean
	public HttpFirewall defaultHttpFirewall() {
	    return new DefaultHttpFirewall();
	}


	

	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
