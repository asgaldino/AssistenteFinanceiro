package com.galdino.AssistenteFinanceiro.Controler;

import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.UserCrudRepository;
import com.galdino.AssistenteFinanceiro.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/users")
public class UserControllerT {
    private final UserRepository userRepository;

    public UserControllerT(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/new")
    public String getUsers(Model model) {
        model.addAttribute("users", new UserBeans());
        return "newUser";
    }
    @PostMapping("/new")
    public String adicionar(@ModelAttribute UserBeans users, Model model) {
        userRepository.save(users);
        List<UserBeans> listaUsers = userRepository.findAll();
        model.addAttribute("users", listaUsers);
        return "users";
    }

    @GetMapping("/users")
    public String listaUsers(@ModelAttribute UserBeans users, Model model) {
        List<UserBeans> listaUsers = userRepository.findAll();
        model.addAttribute("users", listaUsers);
        return "users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserBeans(@PathVariable Long id, Model model) {
        userRepository.deleteById(id);
        List<UserBeans> listaUsers = userRepository.findAll();
        model.addAttribute("users", listaUsers);
        return "users";
    }

    @GetMapping("/{id}")
    UserBeans getUserBeans(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    /*

    @GetMapping("/edit/{id}")
    UserBeans updateUserBeans(@RequestBody UserBeans newUser, @PathVariable Long id) {
        UserBeans users = userRepository.findById(id).get();
        users.setName(newUser.getName());
        users.setEmail(newUser.getEmail());
        users.setPassword(newUser.getPassword());
        users.setIncome(newUser.getIncome());

        return userRepository.save(users);
    }

     */

    @GetMapping ("/edit/{id}")
    public String altProdutos(@PathVariable Long id, Model model) {
        UserBeans u = userRepository.findById(id).get();
        model.addAttribute("users", u);
        return "editUser";
    }
    @PostMapping("/edit")
    public String updateproduto(@ModelAttribute UserBeans newUser, Model model) {
        UserBeans u = userRepository.findById(newUser.getId()).get();
        if (newUser.getName() != null) {
            u.setName(newUser.getName());
        }
        if (newUser.getName() != null) {
            u.setEmail(newUser.getEmail());
        }
        u.setPassword(newUser.getPassword());
        u.setIncome(newUser.getIncome());
        userRepository.save(u);
        List<UserBeans> listaProdutos = userRepository.findAll();
        model.addAttribute("users", listaProdutos);
        return "users";

    }

}
