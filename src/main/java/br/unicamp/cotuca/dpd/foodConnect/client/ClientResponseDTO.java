package br.unicamp.cotuca.dpd.foodConnect.client;

public record ClientResponseDTO(Long id, String fullname, String email, String cep, String delivery, Integer phone, String payment) {
    
    public ClientResponseDTO(Client client){
        this(client.getId(), client.getFullname(), client.getEmail(), client.getCep(), client.getDelivery(), client.getPhone(), client.getPayment()); 
    }

}
