package com.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String userPassword;

    public Employee() {
    }

    public Employee(String firstName, String userPassword) {
        this.userName = firstName;
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
