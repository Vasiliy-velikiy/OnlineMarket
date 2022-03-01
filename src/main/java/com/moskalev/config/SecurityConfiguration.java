package com.moskalev.config;


import com.moskalev.security.JwtRequestFilter;
import com.moskalev.service.impl.PasswordEncryptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class configuration for springSecurity
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncryptionService passwordEncryptionService;

    private final JwtRequestFilter filter;

    /**
     * antMatchers()-ignore some endpoints
     *
     * @param web -class for binding security, application and client requests
     */
    @Override
    public void configure(WebSecurity web) {
        super.configure(web);
        web.ignoring().antMatchers("/api/startPages/signUp", "/api/startPages/signIn");
    }

    /**
     * We add filter in queue of filters
     * this filter will call from each method that not entered in list of antMatchers
     * @param http -Object HttpSecurity
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.cors().disable()
                .csrf().disable();
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
