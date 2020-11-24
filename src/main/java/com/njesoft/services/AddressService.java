package com.njesoft.services;

import com.njesoft.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> addressList();

    Optional<Address> findById(Integer id);

    Address addAddress(Address address);

    String deleteAddress(Integer id);
}
