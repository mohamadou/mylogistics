package com.mohamadou.mylogistics.service;

import com.mohamadou.mylogistics.entity.Address;
import com.mohamadou.mylogistics.entity.Customer;
import com.mohamadou.mylogistics.repository.AddressRepository;
import com.mohamadou.mylogistics.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    AddressRepository addressRepository;
    CustomerRepository customerRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    public AddressService() {
    }

    public List<Address> getAddresses() {

        return addressRepository.findAll();
    }

    public Address getAddressById(Long addressId) {

        Optional<Address> optionalAddress = addressRepository.findById(addressId);

        Address address = null;
        if(optionalAddress.isPresent()) {
            address = optionalAddress.get();
            return address;
        }
        return address;
    }

    public void createAddress(Long customerId, Address address) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        //Check if customer exist before creating a new address
        if(customerOptional.isEmpty()) {
            throw new IllegalStateException("Customer doesnt exist");
        }

        //Check if address with the customer ID exist in the table
        /*if(customer.get().getAddress() != null) {
            throw new RuntimeException("Address Already exist");
        }*/

        //customer.get().setAddress(address);
//        address.setCustomer(customer.get());

        Customer customer = customerOptional.get();
       // customer1.addAddress(address);

        address.setCustomer(customer);
        addressRepository.save(address);
//        customerRepository.save(customer1);
    }

    public Address updateAddress(Address address) {
    Optional<Address> addressOptional = addressRepository.findById(address.getId());

        if(addressOptional.isEmpty()) {
            throw new IllegalStateException("Address does not exists");
        }

        return addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);

        if(addressOptional.isEmpty()) {
            throw  new IllegalStateException("Address does not exists");
        }

        addressRepository.deleteById(addressId);
    }
}
