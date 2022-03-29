package uz.demo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import uz.demo.demo.enums.Permissions;
import uz.demo.demo.enums.Role;

@Configuration
@EnableWebSecurity
public class Configurations extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("admin123")).roles(Role.ADMIN.name())
//                .and()
//                .withUser("user").password(passwordEncoder().encode("user123")).roles(Role.USER.name());
//
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/new/employe/*").hasAuthority(Permissions.EMPLOYE_READ.getPermission())
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(User.builder()
                .username("user")
                .password(passwordEncoder().encode("user123"))
                .authorities(Role.USER.getAuthorities())
                .build(),
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin123"))
                        .authorities(Role.ADMIN.getAuthorities())
                        .build());



    }
}
