package com.example.crudproduto;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ConfiguracaoSpringMvc implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/").setViewName("home");
        //registry.addViewController("/home").setViewName("home");

        registry.addRedirectViewController("/", "/produto/list");
        registry.addRedirectViewController("/home", "/produto/list");
    }
}
