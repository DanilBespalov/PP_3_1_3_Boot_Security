package ru.kata.spring.boot_security.demo.entity;

import org.springframework.security.core.GrantedAuthority;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "roles")
public class Roles implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int role_id;
    @Column(name = "role_name")
    private String role_name;

    @Transient
    @ManyToMany(mappedBy = "ROLES")
    private List<User> userSet;

    public Roles() {
    }

    public Roles(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    @Override
    public String getAuthority() {
        return this.role_name;
    }

    public List<User> getUser() {
        return userSet;
    }
}
