package com.njesoft.controller;

import com.njesoft.model.Address;
import com.njesoft.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("/list")
    public List<Address> addressList() {
        return addressService.addressList();
    }

    @RequestMapping("/list/{id}")
    public Optional<Address> findById(@PathVariable Integer id) {
        return addressService.findById(id);
    }

    @RequestMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @RequestMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Integer id) {
        return addressService.deleteAddress(id);
    }
}
