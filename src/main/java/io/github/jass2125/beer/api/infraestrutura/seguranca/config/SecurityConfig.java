//package io.github.jass2125.beer.api.infraestrutura.seguranca.config;
//
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private MyUserDetails myUserDetailsService;
////
////    @Autowired
////    private JwtTokenProvider tokenProvider;
////
////    @Override
////    @Bean
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
////
////    @Autowired
////    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(myUserDetailsService).passwordEncoder(encoder());
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        http.anonymous().and().authorizeRequests().anyRequest().permitAll();
////        http.addFilterBefore(new JwtTokenFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
////    }
////
////    @Bean
////    public BCryptPasswordEncoder encoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//}
