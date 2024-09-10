package com.elbuensabor.apirest.Controller;

import com.elbuensabor.apirest.Entity.Client;
import com.elbuensabor.apirest.Service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @GetMapping
    public List<Client> getAllClients() {
        return clientServiceImpl.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientServiceImpl.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client newClient = clientServiceImpl.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updatedClient = clientServiceImpl.updateClient(id, client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientServiceImpl.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}

