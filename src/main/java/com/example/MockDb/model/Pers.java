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
    @Column(name = "content", columnDefinition = "jsonb")
    private String content;

    public Pers(Long id, String login, String password, String context) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.content = context;
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
        return content;
    }

    public void setContext(String context) {
        this.content = context;
    }
}
