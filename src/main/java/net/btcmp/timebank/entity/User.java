package net.btcmp.timebank.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

//(name="User")
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "phone", unique=true)
    private String phone;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties(value = "user")
    private Set<Service> services;

    public User() {
//        empty constructor
    }

    public User(Long id, String username, String phone, String password) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
