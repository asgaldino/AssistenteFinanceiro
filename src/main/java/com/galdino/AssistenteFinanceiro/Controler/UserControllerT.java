package com.galdino.AssistenteFinanceiro.Controler;

import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.UserRepository;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @GetMapping("/new")
    public String getUsers(Model model) {
        model.addAttribute("users", new UserBeans());
        return "/user/newUser";
    }
    @PostMapping("/new")
    public String adicionar(@ModelAttribute UserBeans users, Model model) {
        passwordEncoder.encode(users.getPassword());
        userRepository.save(users);
        List<UserBeans> usersList = userRepository.findAll();
        model.addAttribute("users", usersList);
        return "/user/users";
    }

    @GetMapping("/users")
    public String listaUsers(@ModelAttribute UserBeans users, Model model) {
        List<UserBeans> listaUsers = userRepository.findAll();
        model.addAttribute("users", listaUsers);
        return "/user/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserBeans(@PathVariable Long id, Model model) {
        userRepository.deleteById(id);
        List<UserBeans> usersList = userRepository.findAll();
        model.addAttribute("users", usersList);
        return "/user/users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        UserBeans u = userRepository.findById(id).get();
        model.addAttribute("users", u);
        return "/user/users";
    }

    @GetMapping ("/edit/{id}")
    public String altProdutos(@PathVariable Long id, Model model) {
        UserBeans u = userRepository.findById(id).get();
        model.addAttribute("users", u);
        return "/user/editUser";
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
        u.setPassword(passwordEncoder.encode(newUser.getPassword()));
        u.setIncome(newUser.getIncome());
        userRepository.save(u);
        List<UserBeans> usersList = userRepository.findAll();
        model.addAttribute("users", usersList);
        return "/user/users";
    }

}
