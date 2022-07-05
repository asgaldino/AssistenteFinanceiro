package com.galdino.AssistenteFinanceiro.Controler;


import com.galdino.AssistenteFinanceiro.Model.Entitys.ExpenseBeans;
import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.ExpenseCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping(path="/expense")
public class ExpenseController {

    @Autowired
    private ExpenseCrudRepository expenseCrudRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addUser(
            @RequestParam String receiver, @RequestParam String item, @RequestParam int number_installments,
            @RequestParam BigDecimal value_installments, @RequestParam String due_date,
            @RequestParam String purchase_date, @RequestParam UserBeans user_beans_id) {
        // realiza o incapsulamento dos dasos
        ExpenseBeans expense = new ExpenseBeans();
        expense.setReceiver(receiver);
        expense.setItem(item);
        expense.setNumber_installments(number_installments);
        expense.setValue_installments(value_installments);
        expense.setDue_date(due_date);
        expense.setPurchase_date(purchase_date);
        expense.setUserBeans(user_beans_id);
        // salvar o novo Usuario no banco
        expenseCrudRepository.save(expense);
        return "Salvo";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<ExpenseBeans> allExpense() {
        return expenseCrudRepository.findAll();
    }

    @PutMapping(path="/update")
    public @ResponseBody String updateUser(
            @RequestParam Long id, @RequestParam String receiver, @RequestParam String item,
            @RequestParam String number_installments, @RequestParam String value_installments,
            @RequestParam String due_date, @RequestParam String purchase_date) {

        ExpenseBeans expense = expenseCrudRepository.findById(id).get();
        if (!receiver.isEmpty()) {
            expense.setReceiver(receiver);
        }
        if (!item.isEmpty()) {
            expense.setItem(item);
        }
        if (!number_installments.isEmpty()) {
            //Converte a string em int
            int number_installmentsB = Integer.parseInt(number_installments);
            expense.setNumber_installments(number_installmentsB);
        }
        if (!value_installments.isEmpty()) {
            //Converte a string em BigDecimal
            BigDecimal value_installmentsB = new BigDecimal(value_installments);
            expense.setValue_installments(value_installmentsB);
        }
        if (!due_date.isEmpty()) {
            expense.setDue_date(due_date);
        }
        if (!purchase_date.isEmpty()) {
            expense.setPurchase_date(purchase_date);
        }
        expenseCrudRepository.save(expense);

        return "Alterado";
    }
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteExpense(@RequestParam Long id) {
        expenseCrudRepository.deleteById(id);
        return "Apagado";
    }
}
