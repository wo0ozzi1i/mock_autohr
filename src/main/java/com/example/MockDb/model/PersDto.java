package com.example.MockDb.model;

import com.fasterxml.jackson.databind.JsonNode;

public class PersDto {
    private Long id;
    private String login;
    private String password;
    private JsonNode content;


//    public Pers toPers(){
//        Pers pers = new Pers();
//        pers.setId(id);
//        pers.setLogin(login);
//        pers.setPassword(password);
//        pers.setContext(content);
//    }

    public PersDto() {
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

    public JsonNode getContent() {
        return content;
    }

    public void setContent(JsonNode content) {
        this.content = content;
    }
}
