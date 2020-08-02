package br.com.dominio.livros.api.config;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig /* extends WebSecurityConfigurerAdapter */ {
	//@Autowired
    //private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
 
	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication()
	 * .withUser("admin").password("admin").roles("ROLE"); }
	 */
 
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/securityNone").permitAll() //
	 * permitir acesso a um endpoint específico .anyRequest().authenticated() //
	 * Qualquer requisição precisa estar autenticada .and() .httpBasic() .and()
	 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	 * .and() .csrf().disable(); }
	 */
    
}
