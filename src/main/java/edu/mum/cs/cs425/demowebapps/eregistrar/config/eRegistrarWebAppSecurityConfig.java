package edu.mum.cs.cs425.demowebapps.eregistrar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class eRegistrarWebAppSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    public eRegistrarWebAppSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // .csrf().disable() // Note: Do NOT disable CSRF protection
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/static/**", "/css/**", "/images/**", "/js/**", "/eregistrar/public/**")
                .permitAll()
                .antMatchers("/", "/eregistrar").permitAll()
                .antMatchers("/eregistrar/secured/admin/**").hasRole("ADMIN")
                .antMatchers("/eregistrar/secured/registrar/**").hasRole("REGISTRAR")
                .antMatchers("/eregistrar/secured/student/**").hasRole("STUDENT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/eregistrar/public/login")
                .defaultSuccessUrl("/eregistrar/public/home")
                .failureUrl("/eregistrar/public/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/eregistrar/public/logout"))
                .logoutUrl("/eregistrar/public/logout")
                .logoutSuccessUrl("/eregistrar/public/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();
    }
}
