package com.galdino.AssistenteFinanceiro.Controler;

import com.galdino.AssistenteFinanceiro.Model.Entitys.ExpenseBeans;
import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.ExpenseCrudRepository;
import com.galdino.AssistenteFinanceiro.Repository.UserCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path="/api/expense")
public class ExpenseController {

    private final ExpenseCrudRepository expenseCrudRepository;
    private final UserCrudRepository userCrudRepository;

    public ExpenseController(
            ExpenseCrudRepository expenseCrudRepository,
            UserCrudRepository userCrudRepository) {

        this.expenseCrudRepository = expenseCrudRepository;
        this.userCrudRepository = userCrudRepository;
    }
    @PostMapping(path="/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ExpenseBeans addUser(@RequestParam Long userid, @RequestBody ExpenseBeans expense) {

        UserBeans user = userCrudRepository.findById(userid).get();
        expense.setUser(user);
        return expenseCrudRepository.save(expense);
    }
    @GetMapping(path="/all")
    public Iterable<ExpenseBeans> allExpense() {
        return expenseCrudRepository.findAll();
    }
    @GetMapping(path="/catch")
    public ExpenseBeans selectExpense(@RequestParam Long id) {
        return expenseCrudRepository.findById(id).get();
    }
    @GetMapping(path="/catchByUser")
    public Iterable<ExpenseBeans> selectExpenseByUser(@RequestParam Long fk) {
        return expenseCrudRepository.findByFk(fk);
    }
    @PutMapping(path="/update")
    public String updateUser(
            @RequestParam Long id, @RequestParam String receiver, @RequestParam String item,
            @RequestParam String number_installments, @RequestParam BigDecimal value_installments,
            @RequestParam String due_date, @RequestParam String purchase_date) {

        ExpenseBeans expense = expenseCrudRepository.findById(id).get();
        if (receiver != null) {
            expense.setReceiver(receiver);
        }
        if (item != null) {
            expense.setItem(item);
        }if (number_installments != null) {
            //Converte a string em int
            int number_installmentsB = Integer.parseInt(number_installments);
            expense.setNumber_installments(number_installmentsB);
        }if (value_installments != null) {
            //Converte a string em BigDecimal
           // BigDecimal value_installmentsB = new BigDecimal(value_installments);
            expense.setValue_installments(value_installments);
        }if (due_date != null) {
            expense.setDue_date(due_date);
        }if (purchase_date != null) {
            expense.setPurchase_date(purchase_date);
        }expenseCrudRepository.save(expense);
        return "Alterado";
    }
    @DeleteMapping(path="/delete")
    public String deleteExpense(@RequestParam Long id) {
        expenseCrudRepository.deleteById(id);
        return "Apagado";
    }
}
