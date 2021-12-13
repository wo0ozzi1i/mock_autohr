package com.example.MockDb.model;


import javax.persistence.*;

@Entity
@Table(name = "pers")
public class Pers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String login;
    private String password;
    @Column(name = "content")
    private String context;

    public Pers(Long id, String login, String password, String context) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.context = context;
    }

    public Pers(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Pers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
