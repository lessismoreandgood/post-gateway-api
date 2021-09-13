package com.example.clientapi.services;

import com.example.clientapi.models.Client;

public interface ClientService {
    Client getClientById(Long id);

    Client saveClient(Client client);

    void deleteClientById(Long id);
}
