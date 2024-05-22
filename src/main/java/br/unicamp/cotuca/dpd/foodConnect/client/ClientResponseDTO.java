package br.unicamp.cotuca.dpd.foodConnect.client;

public record ClientResponseDTO(Long id, String nome, String email, Integer cep, Integer numEndereco, String complemento, String entrega, Integer telefone, String pagamento) {
    
    public ClientResponseDTO(Client client){
        this(client.getId(), client.getNome(), client.getEmail(), client.getCep(), client.getNumEndereco(), client.getComplemento(), client.getEntrega(), client.getTelefone(), client.getPagamento()); 
    }

}
