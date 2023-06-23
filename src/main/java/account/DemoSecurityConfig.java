package account;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;


@Configuration
@ComponentScan(basePackages = {"com.nss.account"})
public class DemoSecurityConfig {

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource)
//    {
//        return new JdbcUserDetailsManager(dataSource);
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(configurer ->
//                        configurer
//                                .anyRequest().authenticated()
//                )
//                .formLogin(form ->
//                        form
//                                .loginPage("/signInForm")
//                                .loginProcessingUrl("/login")
//                                .permitAll());
//        return httpSecurity.build();
//    }


}
