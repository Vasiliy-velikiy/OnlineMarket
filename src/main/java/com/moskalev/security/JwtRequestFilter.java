package com.moskalev.security;

import com.moskalev.dto.personDto.PersonDto;
import com.moskalev.entities.Person;
import com.moskalev.exeptions.PersonException;
import com.moskalev.mapper.impl.PersonMapper;
import com.moskalev.repositories.PersonRepository;
import com.moskalev.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 01.02.22
 * Class filter for access
 */
@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final PersonRepository personRepository;

    private final TokenService tokenService;

    private final PersonMapper persMapper;

    /**
     * change http request and add headers AUTHORIZATION.We put token from new header
     * @param filterChain
     * @param request
     * @param response
     */
    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("AUTHORIZATION");
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (token != null && securityContext.getAuthentication() == null) {
            String personName = tokenService.extractUsernameAndValidate(token);
            Optional<Person> personOptional = personRepository.findByEmail(personName);
            if (personOptional.isPresent()) {
                PersonDto person = persMapper.toDto(personOptional.get());
                List listRole = new ArrayList(Collections.singleton(new SimpleGrantedAuthority("ROLE_" + person.getRole())));
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(person, null, listRole);
                securityContext.setAuthentication(usernamePasswordAuthenticationToken);
            } else {
                throw new PersonException("Person not found");
            }
        }
        filterChain.doFilter(request, response);
    }
}
