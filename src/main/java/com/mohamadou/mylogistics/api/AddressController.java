package com.mohamadou.mylogistics.api;

import com.mohamadou.mylogistics.entity.Address;
import com.mohamadou.mylogistics.entity.Customer;
import com.mohamadou.mylogistics.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    public AddressController() {
    }

    @GetMapping
    public List<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping(path = "{addressId}")
    public Address getAddressById(@PathVariable Long addressId) {
        return addressService.getAddressById(addressId);
    }

    @PostMapping(path = "{customerId}")
    public void createAddress(@RequestBody Address address, @PathVariable Long customerId) {
        addressService.createAddress(customerId, address);
    }

    @DeleteMapping(path = "{addressId}")
    public void deleteAddressById(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
    }


    @GetMapping(path = "{addressId}/customer/")
    public Customer getCustomerFromAddressById(@PathVariable Long addressId) {
        Address address = addressService.getAddressById(addressId);
        return address.getCustomer();
    }

}
