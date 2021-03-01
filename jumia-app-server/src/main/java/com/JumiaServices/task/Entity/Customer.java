package com.JumiaServices.task.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", p_number='" + p_number + '\'' +
                '}';
    }

    @Column(name = "phone")
    private String p_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getP_number() {
        return p_number;
    }

    public void setP_number(String p_number) {
        this.p_number = p_number;
    }
}
