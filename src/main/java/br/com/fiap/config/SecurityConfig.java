package br.com.fiap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Autowired
	private CustomDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	

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
            http.headers().frameOptions().disable();
		
		http.csrf().disable();
		http.authorizeRequests().antMatchers(PUBLICO).permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin();
        //.loginPage("/")
        //.loginProcessingUrl("/cadastrar/salvar")
        //.defaultSuccessUrl("/dashboard", true);
        //.failureUrl("/login.html?error=true")
        //.and()
        //.logout()
        //.logoutUrl("/logout")
        //.deleteCookies("JSESSIONID");
		http.addFilter(new JWTAuthFilter(authenticationManager(), jwtUtil));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public PasswordEncoder bcpe() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(bcpe());
    }
	
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//		return source;
//	}
}
