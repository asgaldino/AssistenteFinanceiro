package com.galdino.AssistenteFinanceiro.Model.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_expense")
public class ExpenseBeans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Nome do credor
    @Column(nullable = false, length = 100)
    private String receiver;
    // Nome do objeto da divida
    @Column(nullable = false, length = 100)
    private String item;
    // Quantidade de parcelas
    @Column(nullable = false)
    private int number_installments;
    // Valor das parcelas
    @Column(nullable = false)
    private BigDecimal value_installments;
    // Data de Vencimento
    @Column(nullable = false, length = 2)
    private String due_date;
    // Data da Compra
    @Column(nullable = false, length = 10)
    private String purchase_date;


    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnore
    private UserBeans user;

    public UserBeans getUser() {
        return user;
    }

    public void setUser(UserBeans user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getNumber_installments() {
        return number_installments;
    }

    public void setNumber_installments(int number_installments) {
        this.number_installments = number_installments;
    }

    public BigDecimal getValue_installments() {
        return value_installments;
    }

    public void setValue_installments(BigDecimal value_installments) {
        this.value_installments = value_installments;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    @Override
    public String toString() {
        return "ExpenseBeans{" +
                "id=" + id +
                ", receiver='" + receiver + '\'' +
                ", item='" + item + '\'' +
                ", number_installments=" + number_installments +
                ", value_installments=" + value_installments +
                ", due_date='" + due_date + '\'' +
                ", purchase_date='" + purchase_date + '\'' +
                ", user=" + user +
                '}';
    }
}
