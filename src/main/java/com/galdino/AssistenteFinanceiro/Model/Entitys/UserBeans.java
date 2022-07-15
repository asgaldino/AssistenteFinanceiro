package com.galdino.AssistenteFinanceiro.Model.Entitys;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "tb_user")
public class UserBeans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false, length = 12)
    private String password;
    @Column(nullable = false)
    private BigDecimal income;
    @Column(nullable = false)
    private final String role = "user";

    //@OneToMany
    //private List<ExpenseBeans> expenseBeans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getRole() {
        return role;
    }

    //public void setRole(String role) {
    //    this.role = role;
    //}

    @Override
    public String toString() {
        return "UserBeans{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", income=" + income +
                ", role='" + role + '\'' +
                '}';
    }
}
