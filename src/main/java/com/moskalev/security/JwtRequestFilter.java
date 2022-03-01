package com.moskalev.security;

//import com.moskalev.dto.personDto.PersonToUpdateDto;
//import com.moskalev.entities.Person;
//import com.moskalev.exeptions.PersonException;
//import com.moskalev.mapper.PersMapper;
//import com.moskalev.repositories.PersonRepository;
//import com.moskalev.service.TokenService;
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;

//@Component
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
public class JwtRequestFilter {//extends OncePerRequestFilter {

//    private final PersonRepository personRepository;
//
//    private final TokenService tokenService;
//
//    private final PersMapper persMapper;
//
//
//    //за аунтификацию отвечает заголовок запроса, мы должны этот заголовок достать
//    //нужно из токена достать имя пользователя -1 требование
//    @Override
//    @SneakyThrows
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String token = request.getHeader("AUTHORIZATION");
//        SecurityContext securityContext = SecurityContextHolder.getContext(); //кладем токен  в контекст
//        if (token != null&& securityContext.getAuthentication() == null) {//проверяем есть ли контекс-если нет то пользователя начинаем авторизовывать
//                String personName = tokenService.extractUsernameAndValidate(token);//возвращаем креденшал(имя пользователя)
//                Optional<Person> personOptional = personRepository.findByEmail(personName);
//                if (personOptional.isPresent()) {
//                    PersonToUpdateDto person = persMapper.toUpdateDto(personOptional.get());
//                    List listRole = new ArrayList(Collections.singleton(new SimpleGrantedAuthority("ROLE_" + person.getRole())));
//                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                            new UsernamePasswordAuthenticationToken(person, null, listRole);//principal- сам пользователь credential-имя и пароль  authories -роли
//                securityContext.setAuthentication(usernamePasswordAuthenticationToken);//в контекст кладем токен
//                } else {
//                    throw new PersonException("Person not found");
//                }
//        }
//        filterChain.doFilter(request, response);//проверяем валидный токен или нет//применение патерна чейнреспонсабилти
//    }
}
