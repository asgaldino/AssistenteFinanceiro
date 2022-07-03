package com.galdino.AssistenteFinanceiro.Controler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ControllerMVC implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {// Faz o mapeamento das Views para as páginas
        //registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/new").setViewName("newUser");
        registry.addViewController("/nExpense").setViewName("newExpense");
        registry.addViewController("/login").setViewName("login");
    }

}