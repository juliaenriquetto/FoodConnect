package br.unicamp.cotuca.dpd.foodConnect.client;

public record ClientRequestDTO(String nome, String email, Integer cep, Integer numEndereco, String complemento, String entrega, Integer telefone, String pagamento) {
}
