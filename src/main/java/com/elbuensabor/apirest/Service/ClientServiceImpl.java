package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Client;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) throws MiException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new MiException("Client not found with id: " + id));
    }

    @Override
    @Transactional
    public Client createClient(Client client) throws MiException {
        try {
            return clientRepository.save(client);
        } catch (Exception e) {
            throw new MiException("Error creating client!");
        }
    }

    @Override
    @Transactional
    public Client updateClient(Long id, Client client) throws MiException {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new MiException("Client not found with id: " + id));

        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setPhone(client.getPhone());
        existingClient.setEmail(client.getEmail());
        existingClient.setRequests(client.getRequests());
        existingClient.setAddress(client.getAddress());

        try {
            return clientRepository.save(existingClient);
        } catch (Exception e) {
            throw new MiException("Error updating client!");
        }
    }

    @Override
    @Transactional
    public void deleteClient(Long id) throws MiException {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new MiException("Client not found with id: " + id));

        try {
            clientRepository.delete(existingClient);
        } catch (Exception e) {
            throw new MiException("Error deleting client!");
        }
    }
}
