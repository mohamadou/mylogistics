package com.mohamadou.mylogistics.rest;

import com.mohamadou.mylogistics.entity.Address;
import com.mohamadou.mylogistics.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/address")
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
        return  addressService.getAddresses();
    }

    @GetMapping(path = "{addressId}")
    public Address getAddressById(@PathVariable Long addressId) {
        return null;
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return null;
    }
}
