package com.galdino.AssistenteFinanceiro.Controler;

import com.galdino.AssistenteFinanceiro.Model.Entitys.ExpenseBeans;
import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.ExpenseRepository;
import com.galdino.AssistenteFinanceiro.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/expenses")
public class ExpenseControllerT {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseControllerT(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/new")
    public String getUsers(Model model) {
        ExpenseBeans e = new ExpenseBeans();
        // Variável que define o id do usuário
        // implemntar substituição em cenario com mais de um usuário
        Long userid = 1L;
        UserBeans user = userRepository.findById(userid).get();
        e.setUser(user);
        System.out.println(user.id);
        model.addAttribute("expenses", e);
        return "/expense/newExpense";
    }

    @PostMapping("/new")
    public String adicionar(@ModelAttribute ExpenseBeans expenses, Model model) {
        expenseRepository.save(expenses);
        List<ExpenseBeans> expenseList = expenseRepository.findAll();
        model.addAttribute("expenses", expenseList);
        return listaExpenses(expenses, model);
    }
    @GetMapping(path="/catchByUser")
    public Iterable<ExpenseBeans> selectExpenseByUser(@RequestParam Long fk) {
        return expenseRepository.findByFk(fk);
    }

    @GetMapping("/expenses")
    public String listaExpenses(@ModelAttribute ExpenseBeans expenses, Model model) {
        // Variável que define o id do usuário
        // implemntar substituição em cenario com mais de um usuário
        Long userid = 1L;
        UserBeans user = userRepository.findById(userid).get();
        System.out.println(user.getIncome());
        List<ExpenseBeans> expenseList = expenseRepository.findByFk(userid);
        model.addAttribute("expenses", expenseList);
        return "/expense/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserBeans(@PathVariable Long id,@ModelAttribute ExpenseBeans expenses, Model model) {
        expenseRepository.deleteById(id);
        List<ExpenseBeans> expenseList = expenseRepository.findAll();
        model.addAttribute("expenses", expenseList);
        return listaExpenses(expenses, model);
    }
    @GetMapping("/{id}")
    ExpenseBeans getUserBeans(@PathVariable Long id) {
        return expenseRepository.findById(id).get();
    }

    @GetMapping ("/edit/{id}")
    public String altProdutos(@PathVariable Long id, Model model) {
        ExpenseBeans u = expenseRepository.findById(id).get();
        model.addAttribute("expenses", u);
        return "/expense/editExpenses";
    }
    @PostMapping("/edit")
    public String updateproduto(@ModelAttribute ExpenseBeans newExpense,@ModelAttribute ExpenseBeans expenses, Model model) {
        ExpenseBeans u = expenseRepository.findById(newExpense.getId()).get();
        if (newExpense.getReceiver() != null) {
            u.setReceiver(newExpense.getReceiver());
        }
        if (newExpense.getItem() != null) {
            u.setItem(newExpense.getItem());
        }
        u.setNumber_installments(newExpense.getNumber_installments());
        u.setValue_installments(newExpense.getValue_installments());
        u.setDue_date(newExpense.getDue_date());
        u.setPurchase_date(newExpense.getPurchase_date());
        expenseRepository.save(u);
        List<ExpenseBeans> expensesList = expenseRepository.findAll();
        model.addAttribute("expenses", expensesList);
        return listaExpenses(expenses, model);
    }
}
