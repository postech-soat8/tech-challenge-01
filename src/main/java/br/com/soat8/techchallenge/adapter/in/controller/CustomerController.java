package br.com.soat8.techchallenge.adapter.in.controller;

import br.com.soat8.techchallenge.core.port.in.CustomerUseCase;
import br.com.soat8.techchallenge.domain.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/lanchonete/customer";

    private final CustomerUseCase customerUseCase;

    public CustomerController(CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody Customer customer) {
        customerUseCase.saveCustomer(customer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Customer> searchCustomerCpf(@Valid @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "CPF invalid") String cpf) {

        Customer result = customerUseCase.searchCustomerCpf(cpf);

        return ResponseEntity.ok(result);
    }

}