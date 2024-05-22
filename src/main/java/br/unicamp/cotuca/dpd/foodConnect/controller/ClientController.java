package br.unicamp.cotuca.dpd.foodConnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.cotuca.dpd.foodConnect.client.Client;
import br.unicamp.cotuca.dpd.foodConnect.client.ClientRepository;
import br.unicamp.cotuca.dpd.foodConnect.client.ClientRequestDTO;
import br.unicamp.cotuca.dpd.foodConnect.client.ClientResponseDTO;

//indicando que é um controller
@RestController
@RequestMapping("/client") // endpoint
public class ClientController {

    //criando o objeto do repositorio
    @Autowired
    private ClientRepository repository; 

    //@CrossOrigin(origins = "*", allowedHeaders = "*") conectar com o front e restringir dominios
    @PostMapping
    public void saveClient(@RequestBody ClientRequestDTO data) {
       Client clientData = new Client(data);
       repository.save(clientData);
       return;
    }

    //pegando todos os dados da api
    //@CrossOrigin(origins = "*", allowedHeaders = "*") conectar com o front e restringir dominios
    @RequestMapping
    public List<ClientResponseDTO> getAll(){
        
        List<ClientResponseDTO> clientList = repository.findAll().stream().map(ClientResponseDTO::new).toList();
        return clientList; 
    }
}
