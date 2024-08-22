package br.com.soat8.techchallenge.core.service;

import br.com.soat8.techchallenge.core.port.in.CustomerUseCase;
import br.com.soat8.techchallenge.core.port.out.CustomerPort;
import br.com.soat8.techchallenge.domain.Customer;
import br.com.soat8.techchallenge.domain.exception.CpfAlreadyExistsException;
import br.com.soat8.techchallenge.domain.exception.CpfNotExistsException;
import br.com.soat8.techchallenge.domain.exception.EmailAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerUseCase {

    private final CustomerPort customerPort;

    public CustomerService(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }

    @Override
    public void saveCustomer(Customer customer) {
        existCpf(customer);
        existEmail(customer);
        customerPort.saveCustomer(customer);
    }

    @Override
    public Customer searchCustomerCpf(String cpf) {
        notExistCpf(cpf);
        return customerPort.searchCustomerCpf(cpf);
    }

    private void notExistCpf(String cpf) {
        if (!customerPort.findByCpf(cpf)){
            throw new CpfNotExistsException("CPF does not exist: " + cpf);
        }
    }

    private void existCpf(Customer customer) {
        if (customerPort.findByCpf(customer.getCpf())){
            throw new CpfAlreadyExistsException("CPF already exists: " + customer.getCpf());
        }
    }

    private void existEmail(Customer customer) {
        if (customerPort.findByEmailAddress(customer.getEmailAddress())){
            throw new EmailAlreadyExistsException("Email already exists: " + customer.getEmailAddress());
        }
    }
}
