package com.galdino.AssistenteFinanceiro.Controler;



import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import javax.swing.*;
import java.math.BigDecimal;


@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email,
    @RequestParam String password, @RequestParam BigDecimal income, @RequestParam String role) {

        // realiza o incapsulamento dos dasos
        UserBeans user = new UserBeans();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setIncome(income);
        user.setRole(role);
        // salvar o novo Usuario no banco
        userCrudRepository.save(user);
        return "Salvo";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserBeans> allUser() {
        return userCrudRepository.findAll();
    }

    // update
    @PutMapping(path="/update")
    public @ResponseBody String updateUser(
            @RequestParam Long id, @RequestParam String name, @RequestParam String email,
            @RequestParam String password, @RequestParam String income) {

        UserBeans user = userCrudRepository.findById(id).get();
        if (!name.isEmpty()) {
            user.setName(name);
        }
        if (!email.isEmpty()) {
            user.setEmail(email);
        }
        if (!password.isEmpty()) {
            user.setPassword(password);
        }
        if (!income.isEmpty()) {
            //Converte a string em BigDecimal
            BigDecimal incomeB = new BigDecimal(income);
            user.setIncome(incomeB);
        }
        userCrudRepository.save(user);

        return "Alterado";
    }
    // Delete
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteUser(@RequestParam Long id) {
        userCrudRepository.deleteById(id);
        return "Apagado";
    }

}