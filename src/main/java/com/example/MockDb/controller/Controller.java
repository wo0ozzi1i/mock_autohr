package com.example.MockDb.controller;

import com.example.MockDb.model.Body;
import com.example.MockDb.model.Pers;
import com.example.MockDb.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    private final static Logger logger = LoggerFactory.getLogger(Controller.class);
    private  UserRepository userRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Optional<Pers> printHello(Long id) {
        return userRepository.findById(id);
    }
    @PostMapping ("/user")
    public String findUser(@RequestBody String str) throws JsonProcessingException {
        StringBuilder login = new StringBuilder();
        StringBuilder password = new StringBuilder();
        if(str!=null) {

            try{
                List<Body> bodyList = objectMapper.readValue(str, new TypeReference<List<Body>>() {});
                login.append(bodyList.get(0).getLogin());
                password.append(bodyList.get(0).getPassword());
            }
            catch (Exception e){

            }
        }

            return userRepository.findByUser(login.toString(), password.toString()).get(0).getContext();
    }
}
