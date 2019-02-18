package com.cr.employee.config;

import com.cr.employee.interceptor.MyLoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return  new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("LoginSuccess.html").setViewName("dashboard");
            }
            //登陆拦截

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyLoginHandlerInterceptor()).
                        addPathPatterns("/**").excludePathPatterns("/","/login");
            }
        };


    }






}
