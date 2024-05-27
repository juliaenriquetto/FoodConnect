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
    private String fullname;
    private String email; 
    private String cep; 
    private String delivery; //retirar ou receber
    private Integer phone; 
    private String payment; //debito, credito, dinheiro
    private String neighborhood;
    private String city; // VIACEPCLIENT
    private String uf; // VIACEPCLIENT
    private String complement; // VIACEPCLIENT
    private Short addressNumber; // VIACEPCLIENT
    private String streetName;

    public Client(ClientRequestDTO data){
        this.fullname = data.fullname(); 
        this.email = data.email();
        this.cep = data.cep();
        this.delivery = data.delivery(); 
        this.phone = data.phone();
        this.payment = data.payment();
    }

    public void setId(Long id) throws Exception {
        if (id == 0){
            throw new IllegalArgumentException("[CLIENT]: Id cannot be null or empty");
        }
        this.id = id;
    }

    public void setName(String nome) throws Exception {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: Name cannot be null or empty");
        }
    }

    public void setEmail(String email) throws Exception {
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: Email cannot be null or empty");
        }
    }

    public void setCep(String cep) throws Exception {
        if(cep == null || cep.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: Cep cannot be null or empty");
        }
    }

    public void setDelivery(String delivery) throws Exception {
        if(delivery == null || delivery.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: Delivery cannot be null or empty");
        }
    }

    public void setPhone(Integer phone) throws Exception {
        if(phone <= 0) {
            throw new IllegalArgumentException("[CLIENT]: Phone cannot be null or empty");
        }
        this.phone = phone; 
    }

    public void setPayment(String payment) throws Exception {
        if(payment == null || payment.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: Payment cannot be null or empty");
        }
    } 

    public void setCity(String city) throws Exception {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: City cannot be null or empty");
        }
        this.city = city;
    }

    public void setNeighborhood(String neighborhood) throws Exception {
        if (neighborhood == null || neighborhood.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: Neighborhood cannot be null or empty");
        }
        this.neighborhood = neighborhood;
    }

    public void setUf(String uf) throws Exception {
        if (uf == null || uf.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: UF cannot be null or empty");
        }
        this.uf = uf;
    }

    public void setComplement(String complement) throws Exception {
        if (complement == null || complement.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: Complement cannot be null or empty");
        }
        this.complement = complement;
    }

    public void setAddressNumber(Short addressNumber) {
        if (addressNumber == null || addressNumber == 0) {
            throw new IllegalArgumentException("[CLIENT]: Telephone cannot be null or empty");
        }
        this.addressNumber = addressNumber;
    }

    public void setStreetName(String streetName) throws Exception {
        if (streetName == null || streetName.trim().isEmpty()) {
            throw new IllegalArgumentException("[CLIENT]: Street name cannot be null or empty");
        }
        this.streetName = streetName;
    }
}
