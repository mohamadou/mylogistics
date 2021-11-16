package com.mohamadou.mylogistics.service;

import com.mohamadou.mylogistics.entity.Address;
import com.mohamadou.mylogistics.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressService() {
    }

    public List<Address> getAddresses() {

        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long addressId) {
        return addressRepository.findById(addressId);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
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
