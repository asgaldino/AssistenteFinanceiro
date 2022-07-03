package com.galdino.AssistenteFinanceiro.Controler;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Af")
public class ControllerAf {

    @PostMapping("new")
    public String getprodutos() {
        return "newUser";
    }

}