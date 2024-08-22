package br.com.soat8.techchallenge.core.port.in;

import br.com.soat8.techchallenge.domain.Customer;

public interface CustomerUseCase {
    void saveCustomer(Customer customer);
    Customer searchCustomerCpf(String cpf);
}
