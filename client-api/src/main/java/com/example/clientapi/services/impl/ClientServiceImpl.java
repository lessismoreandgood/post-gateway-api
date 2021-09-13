package com.example.clientapi.services.impl;

import com.example.clientapi.models.Client;
import com.example.clientapi.repositories.ClientRepository;
import com.example.clientapi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client getClientById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
