package com.example.MockDb.controller;

import com.example.MockDb.model.Body;
import com.example.MockDb.model.Pers;
import com.example.MockDb.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    private final static Logger logger = LoggerFactory.getLogger(Controller.class);
    private  UserRepository userRepository;
    JSONParser jsonParser = new JSONParser();
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public Controller(UserRepository userRepository, JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public Optional<Pers> printHello(Long id) {
        return userRepository.findById(id);
    }
    @PostMapping ("/user")
    public String findUser(@RequestBody String str) throws  ParseException {
        JSONObject json = (JSONObject) jsonParser.parse(str);
        String login = (String) json.get("login");
        logger.info(login);
        String password = (String) json.get("password");
            logger.info("dsadsadds");
            return userRepository.findByUser(login, password).get(0).getContext();
    }
    
    @PostMapping("/user/create")
    public void create(@RequestBody String str) throws JsonProcessingException, ParseException {
        JSONObject json = (JSONObject) jsonParser.parse(str);
        String login = (String) json.get("login");
        logger.info(login);
        String password = (String) json.get("password");
        logger.info(password);
        JSONObject content = (JSONObject) json.get("content");
        logger.info(String.valueOf(content));
        logger.info("debug");
        jdbcTemplate.update("INSERT INTO pers (content, login, password) values (to_json(?),?,?)",content,login,password);


    }
}
