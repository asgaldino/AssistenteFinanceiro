package com.galdino.AssistenteFinanceiro.Repository;

import com.galdino.AssistenteFinanceiro.Model.Entitys.ExpenseBeans;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseCrudRepository extends CrudRepository<ExpenseBeans, Long> {
    //Query personalisada para buscar pela foreign key
    @Query("select e from ExpenseBeans e where e.user.id = :fk")
    List<ExpenseBeans> findByFk(Long fk);
}
