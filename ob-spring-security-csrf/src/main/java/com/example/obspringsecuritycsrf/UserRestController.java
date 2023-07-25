package com.example.obspringsecuritycsrf;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @GetMapping("hola")
    public String hola(){
        return "Hola mundo";
    }

    @PostMapping("/users")
    public String save(@RequestBody UserDTO user){
        System.out.println(user);
        return "OK";
    }
    }