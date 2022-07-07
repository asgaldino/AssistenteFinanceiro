package com.galdino.AssistenteFinanceiro.Repository;

import com.galdino.AssistenteFinanceiro.Model.Entitys.ExpenseBeans;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseCrudRepository extends CrudRepository<ExpenseBeans, Long> {
    @Query("select e from ExpenseBeans e where e.userBeans.id = :user_beans_id")
    ExpenseBeans findByFk(Long user_beans_id);
}
