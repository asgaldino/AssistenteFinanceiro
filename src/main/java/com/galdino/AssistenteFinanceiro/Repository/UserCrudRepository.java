package com.galdino.AssistenteFinanceiro.Repository;

import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<UserBeans, Long> {
}
