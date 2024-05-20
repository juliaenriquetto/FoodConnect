package br.unicamp.cotuca.dpd.foodConnect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//indicando que é um controller
@RestController
@RequestMapping("client") // endpoint
public class ClientController {
    //pegando todos os dados da api
    @RequestMapping
    public void getAll(){
        
    }
}
