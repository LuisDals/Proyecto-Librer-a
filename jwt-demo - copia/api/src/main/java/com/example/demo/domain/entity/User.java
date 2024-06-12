package com.example.demo.domain.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {
    @Id
    private String username;
    @Column(length =255, nullable = false)
    private String password;
    @Column(length =100, nullable = false)
    private String firstName;
    @Column(length =100, nullable = true)
    private String lastName;
    @Column(length =100, nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<BookRegister> registers;
    @Column(name = "total_rental_days")
    private int totalRentalDays;

    public int getTotalRentalDays() {
        return totalRentalDays;
    }

    public void setTotalRentalDays(int totalRentalDays) {
        this.totalRentalDays = totalRentalDays;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<BookRegister> getRegisters() {
        return registers;
    }

    public void setRegisters(List<BookRegister> registers) {
        this.registers = registers;
    }
}
