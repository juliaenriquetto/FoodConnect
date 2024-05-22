package br.unicamp.cotuca.dpd.foodConnect.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.cotuca.dpd.foodConnect.client.Client;
import br.unicamp.cotuca.dpd.foodConnect.client.ClientRepository;

//indicando que é um controller
@RestController
@RequestMapping("/client") // endpoint
public class ClientController {

    //criando o objeto do repositorio
    @Autowired
    private ClientRepository repository; 

    //pegando todos os dados da api
    @RequestMapping
    public List<ClientResponseDTO> getAll(){
        
        List<ClientResponseDTO> clientList = repository.findAll().stream().map(ClientResponseDTO::new).toList();
        return clientList; 
    }
}
