package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Address;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) throws MiException {
        return addressRepository.findById(id).orElseThrow(() -> new MiException("Address not found with id: " + id));
    }

    @Override
    @Transactional
    public Address createAddress(Address address) throws MiException {
        try {
            return addressRepository.save(address);
        } catch (Exception e) {
            throw new MiException("Error creating address!");
        }
    }

    @Override
    @Transactional
    public Address updateAddress(Long id, Address address) throws MiException {
        Address existingAddress = addressRepository.findById(id).orElseThrow(() -> new MiException("Address not found with id: " + id));

        existingAddress.setStreet(address.getStreet());
        existingAddress.setNumber(address.getNumber());
        existingAddress.setCity(address.getCity());
        existingAddress.setClient(address.getClient());
        existingAddress.setRequests(address.getRequests());

        try {
            return addressRepository.save(existingAddress);
        } catch (Exception e) {
            throw new MiException("Error updating address!");
        }
    }

    @Override
    @Transactional
    public void deleteAddress(Long id) throws MiException {
        Address existingAddress = addressRepository.findById(id).orElseThrow(() -> new MiException("Address not found with id: " + id));

        try {
            addressRepository.delete(existingAddress);
        } catch (Exception e) {
            throw new MiException("Error deleting address!");
        }
    }
}

