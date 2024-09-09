package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Client;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(Long id) throws MiException;
    Client createClient(Client client) throws MiException;
    Client updateClient(Long id, Client client) throws MiException;
    void deleteClient(Long id) throws MiException;
}
