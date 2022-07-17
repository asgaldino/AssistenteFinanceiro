package com.galdino.AssistenteFinanceiro.Service;

import com.galdino.AssistenteFinanceiro.Model.Entitys.ExpenseBeans;
import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.UserRepository;

public class getUser {

    private final UserRepository userRepository;



    public getUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public ExpenseBeans expenseByUser(){
        ExpenseBeans e = new ExpenseBeans();
        Long userid = 2L;
        UserBeans user = userRepository.findById(userid).get();
        e.setUser(user);
        System.out.println(user.id);

        return e;
    }

}
