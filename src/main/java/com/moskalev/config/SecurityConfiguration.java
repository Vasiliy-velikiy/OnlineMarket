package com.moskalev.config;

import com.moskalev.security.JwtRequestFilter;
import com.moskalev.service.impl.PasswordEncryptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncryptionService passwordEncryptionService;

    private final JwtRequestFilter filter;


    //antMatchers()секь.рити фильтр должен некоторые ендпоинты игнорить по умолчанию
    @Override
    public void configure(WebSecurity web)  {
        super.configure(web);
        web.ignoring().antMatchers("/api/startPages/signUp", "/api/startPages/signIn");
    }


    //добавляем фильтр в цепочку в самое начало чтобы он авториз юхера перед спринговыми фильтрами
    //этот фильтр будет вызывапться при каждом вызове методов которые не попали в спискок antMatchers(
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    http.cors().disable()
                        .csrf().disable();
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }

}
