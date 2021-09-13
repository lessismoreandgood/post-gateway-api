package com.example.clientapi.rest;

import com.example.clientapi.models.Client;
import com.example.clientapi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/")
public class ClientRestController {
    @Autowired
    ClientService clientServiceService;

    @GetMapping("{client_id}")
    public ResponseEntity<Client> getClient(@PathVariable(name = "client_id") Long clientId){
        Client client = clientServiceService.getClientById(clientId);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        clientServiceService.saveClient(client);

        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @PutMapping("update/{client_id}")
    public ResponseEntity<Client> updateClient(@PathVariable(name = "client_id") Long clientId, @RequestBody Client client){
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        clientServiceService.saveClient(client);

        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{client_id}")
    public ResponseEntity<Client> deleteClientById(@PathVariable(name = "client_id") Long clientId){
        Client client = clientServiceService.getClientById(clientId);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clientServiceService.deleteClientById(clientId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
