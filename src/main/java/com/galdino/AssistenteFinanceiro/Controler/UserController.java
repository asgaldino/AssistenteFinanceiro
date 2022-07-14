/*
package com.galdino.AssistenteFinanceiro.Controler;

import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.UserCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path="/api/user2")
public class UserController {

    private final UserCrudRepository userCrudRepository;

    public UserController(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @PostMapping(path="/add")
    public ResponseEntity<UserBeans> create(@RequestBody UserBeans user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userCrudRepository.save(user));
    }
    @GetMapping(path="/all")
    public Iterable<UserBeans> allUser() {
        System.out.println(userCrudRepository.findAll());
        return userCrudRepository.findAll();
    }
    @GetMapping(path="/catch")
    public UserBeans selectUser(@RequestParam Long id) {
        return userCrudRepository.findById(id).get();
    }
    @PutMapping(path="/update")
    public String updateUser(
            @RequestParam Long id, @RequestParam String name, @RequestParam String email,
            @RequestParam String password, @RequestParam BigDecimal income) {

        UserBeans user = userCrudRepository.findById(id).get();
        if (name != null) {
            user.setName(name);
        }if (email != null) {
            user.setEmail(email);
        }if (password != null) {
            user.setPassword(password);
        }if (income != null) {
            user.setIncome(income);
        }userCrudRepository.save(user);
        return "Alterado";
    }
    @DeleteMapping(path="/delete")
    public String deleteUser(@RequestParam Long id) {
        userCrudRepository.deleteById(id);
        return "Apagado";
    }
}

 */