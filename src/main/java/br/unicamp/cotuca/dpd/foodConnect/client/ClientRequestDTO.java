package br.unicamp.cotuca.dpd.foodConnect.client;

public record ClientRequestDTO(
    String fullname, 
    String email, 
    String cep, 
    String delivery, 
    Integer phone, 
    String payment,
    String neighborhood,
    String city,
    String uf,
    String complement,
    Short addressNumber,
    String streetName
    ) {}
