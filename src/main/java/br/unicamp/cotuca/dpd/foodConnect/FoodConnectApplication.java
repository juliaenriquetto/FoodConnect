package br.unicamp.cotuca.dpd.foodConnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FoodConnectApplication {
	//ponto de start da aplicação
	public static void main(String[] args) {
		SpringApplication.run(FoodConnectApplication.class, args);
	}
}
