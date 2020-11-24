package com.njesoft.services.impl;

import com.njesoft.model.Address;
import com.njesoft.model.User;
import com.njesoft.repository.AddressRepository;
import com.njesoft.repository.UserRepository;
import com.njesoft.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;

    public AddressServiceImpl(AddressRepository addressRepository,
                              UserRepository userRepository
    ) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Address> addressList() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address addAddress(Address address) {
        User user = userRepository.getOne(address.getUserId());
        if (user != null) {
            address.setUser(user);
            return addressRepository.save(address);
        }

        return address;
    }

    @Override
    public String deleteAddress(Integer id) {
        addressRepository.deleteById(id);
        return "{'message': 'Address deleted successfully.'}";

    }
}
