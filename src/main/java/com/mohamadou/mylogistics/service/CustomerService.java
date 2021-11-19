package com.mohamadou.mylogistics.service;

import com.mohamadou.mylogistics.entity.Customer;
import com.mohamadou.mylogistics.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerService() {
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        Customer customer = null;
        if(optionalCustomer.isPresent()) {
              customer = optionalCustomer.get();
        }
        return customer;
//        throw new RuntimeException("Customer with this ID does not exists");
    }

    public List<Customer> getCustomers() {
        return  customerRepository.findAll();
    }


    public Customer createCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());

        customer.setId(0L);

        if(customerOptional.isPresent()) {
            throw new IllegalStateException("Email taken");

        }

        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isEmpty()) {
            throw new IllegalStateException("Customer does not exist");
        }
        customerRepository.deleteById(customerId);
    }
}
