package br.unicamp.cotuca.dpd.foodConnect.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "client")
@Entity(name = "clients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String nome;
    private String email; 
    private Integer cep; 
    private Integer numEndereco; 
    private String complemento; 
    private String entrega; //retirar ou receber
    private Integer telefone; 
    private String pagamento; //debito, credito, dinheiro

    public Client(ClientRequestDTO data){
        this.nome = data.nome(); 
        this.email = data.email();
        this.cep = data.cep();
        this.numEndereco = data.numEndereco(); 
        this.complemento = data.complemento(); 
        this.entrega = data.entrega(); 
        this.telefone = data.telefone();
        this.pagamento = data.pagamento();
    }
}
