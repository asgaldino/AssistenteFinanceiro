package com.galdino.AssistenteFinanceiro.Repository;

import com.galdino.AssistenteFinanceiro.Model.Entitys.ExpenseBeans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseBeans, Long> {

}
