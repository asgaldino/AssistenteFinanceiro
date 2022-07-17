package com.galdino.AssistenteFinanceiro.Repository;

import com.galdino.AssistenteFinanceiro.Model.Entitys.ExpenseBeans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseBeans, Long> {
    @Query("select e from ExpenseBeans e where e.user.id = :userid")
    List<ExpenseBeans> findByFk(Long userid);

}
