package com.yuriy.spring.web_mvc_rest_security.restful_booker.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.yuriy.spring.web_mvc_rest_security.restful_booker")
@EnableWebMvc
@EnableAspectJAutoProxy
public class MyConfig {
    @Bean
    public ViewResolver viewResolver(){
        return new InternalResourceViewResolver("/WEB-INF/view/",".jsp");
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
