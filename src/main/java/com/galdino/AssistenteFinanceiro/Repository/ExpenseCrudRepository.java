package com.galdino.AssistenteFinanceiro.Repository;

import com.galdino.AssistenteFinanceiro.Model.Entitys.ExpenseBeans;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseCrudRepository extends CrudRepository<ExpenseBeans, Long> {
}
