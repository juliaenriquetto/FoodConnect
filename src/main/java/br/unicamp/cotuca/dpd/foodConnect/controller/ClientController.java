package br.unicamp.cotuca.dpd.foodConnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.cotuca.dpd.foodConnect.client.Client;
import br.unicamp.cotuca.dpd.foodConnect.client.ClientRepository;
import br.unicamp.cotuca.dpd.foodConnect.client.ClientRequestDTO;
import br.unicamp.cotuca.dpd.foodConnect.client.ClientResponseDTO;
import br.unicamp.cotuca.dpd.foodConnect.infrastructure.cep.Address;
import br.unicamp.cotuca.dpd.foodConnect.infrastructure.cep.ViaCepClient;


//indicando que é um controller
@RestController
@RequestMapping("/client") // endpoint
public class ClientController {

    //criando o objeto do repositorio
    @Autowired
    private ClientRepository repository; 

    @Autowired
    private ViaCepClient cepClient;

    @GetMapping
    public List<Client> fetchClients() {
        List<Client> allClients = this.repository.findAll();
        return allClients;
    }

    //@CrossOrigin(origins = "*", allowedHeaders = "*") conectar com o front e restringir dominios
    @PostMapping
    public void createClient(@RequestBody ClientRequestDTO data) {
        try {
            Client client = new Client(data);

            String cep = data.cep();

            Address address = cepClient.fetchAddressByCep(cep);
            client.setCity(address.getLocalidade());
            client.setNeighborhood(address.getBairro());
            client.setUf(address.getUf());
            client.setStreetName(address.getLogradouro());

            repository.save(client);

            return;
        } catch (Exception e) {
            System.out.println("An error occured when trying to create a new Client");
        }
    }

    //pegando todos os dados da api
    //@CrossOrigin(origins = "*", allowedHeaders = "*") conectar com o front e restringir dominios
    @RequestMapping
    public List<ClientResponseDTO> getAll(){
        
        List<ClientResponseDTO> clientList = repository.findAll().stream().map(ClientResponseDTO::new).toList();
        return clientList; 
    }

    //update
    @PutMapping("/clients/{id}")
    public String updateClient(@PathVariable String id) {
       // fazer de cada atributo 
       return null; 
    }

    //delete
    @DeleteMapping("/clients/{id}")
    public String deleteClientItem(@PathVariable("id") Long id) {
        repository.deleteById(id); 

        return ("Client deleted successfully");
    }
}
