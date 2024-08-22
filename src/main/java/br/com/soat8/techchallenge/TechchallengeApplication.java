package br.com.soat8.techchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.soat8.techchallenge.adapter.out.persistence.entity"})
public class TechchallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechchallengeApplication.class, args);
	}

}
