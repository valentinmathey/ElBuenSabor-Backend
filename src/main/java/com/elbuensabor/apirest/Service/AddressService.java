package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Address;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();
    Address getAddressById(Long id) throws MiException;
    Address createAddress(Address address) throws MiException;
    Address updateAddress(Long id, Address address) throws MiException;
    void deleteAddress(Long id) throws MiException;
}
