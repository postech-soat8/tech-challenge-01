package br.com.soat8.techchallenge.adapter.out.persistence.adapter;

import br.com.soat8.techchallenge.adapter.out.persistence.entity.CustomerEntity;
import br.com.soat8.techchallenge.adapter.out.persistence.retository.CustomerRepository;
import br.com.soat8.techchallenge.core.port.out.CustomerPort;
import br.com.soat8.techchallenge.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerAdapter implements CustomerPort {

    private final CustomerRepository customerRepository;

    public CustomerAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(Customer customer) {
        save(customer);
    }

    @Override
    public Customer searchCustomerCpf(String cpf) {

        Customer objCustomer = new Customer();
        Optional<CustomerEntity> customerEntity = customerRepository.findByCpf(cpf);
        if(customerEntity.isPresent()){
            objCustomer.setId(customerEntity.get().getCustomerId().toString());
            objCustomer.setCpf(customerEntity.get().getCpf());
            objCustomer.setName(customerEntity.get().getName());
            objCustomer.setEmailAddress(customerEntity.get().getEmailAddress());
        }
        return objCustomer;
    }

    @Override
    public Boolean findByCpf(String cpf) {
        return customerRepository.findByCpf(cpf).isPresent();
    }

    @Override
    public Boolean findByEmailAddress(String emailAddress) {
        return customerRepository.findByEmailAddress(emailAddress).isPresent();
    }

    private void save(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setEmailAddress(customer.getEmailAddress());
        customerEntity.setCpf(customer.getCpf());
        customerRepository.save(customerEntity);
    }

}
