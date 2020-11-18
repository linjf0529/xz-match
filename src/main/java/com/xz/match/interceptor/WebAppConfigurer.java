package com.xz.match.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author chenwf
 * @date 2020/11/17
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(setBean()).addPathPatterns("/**");
    }

    @Bean
    public AuthInterceptor setBean(){
       return new AuthInterceptor();
    }
}
