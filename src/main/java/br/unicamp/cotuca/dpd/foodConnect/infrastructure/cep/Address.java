package br.unicamp.cotuca.dpd.foodConnect.infrastructure.cep;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Address {
    private String cep;
    private String cidade; 
    private String bairro;
    private String logradouro; 
    private String estado; 
}
