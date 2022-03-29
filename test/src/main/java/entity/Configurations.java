package entity;





import com.payment.test.security.JwtConfigur;
import com.payment.test.security.JwtTokenProvayder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

// urllarga ruxsat berish uchun
@Configuration
@EnableWebSecurity
public class Configurations extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final JwtTokenProvayder jwtTokenProvayder;


    public Configurations(@Lazy UserDetailsService userDetailsService,JwtTokenProvayder jwtTokenProvayder) {
        this.jwtTokenProvayder = jwtTokenProvayder;
        this.userDetailsService = userDetailsService;
    }


    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth
//                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
// data base foydalanmasdan qilish
//                .inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
//                .and()
//                .withUser("user").password(passwordEncoder().encode("user123")).roles("USER");

    //    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.
                csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/api/create").permitAll()
//                .antMatchers("/api/all").hasRole("ADMIN")
                .antMatchers("/api/account/getall").permitAll()
                .antMatchers("/api/account/create").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigur(jwtTokenProvayder));
    }
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
