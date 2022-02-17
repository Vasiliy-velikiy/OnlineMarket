package com.moskalev.config;

import com.moskalev.innterceptor.InterseptorTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {
    private  final InterseptorTest interseptorTest;

    public SpringMvcConfiguration(InterseptorTest interseptorTest) {
        this.interseptorTest = interseptorTest;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//РЕГИСТРИРУЕМ которые приходят на ендпоинты ВСЕ ЗАПРОСЫ-говорим что все наши ендпоинты покрывает этот интерсепотр и он будет вызван
       registry.addInterceptor(interseptorTest).addPathPatterns(); //к чему будет применет интерсептор, еще есть pathMatcher-это ограничение к какому контроллеру будет он примене
    }
}
