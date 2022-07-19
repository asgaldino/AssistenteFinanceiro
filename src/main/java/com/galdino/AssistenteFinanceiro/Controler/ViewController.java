package com.galdino.AssistenteFinanceiro.Controler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class ViewController {

    public void addViewController(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("expense/expenses");
        registry.addViewController("/").setViewName("home");
    }
}
