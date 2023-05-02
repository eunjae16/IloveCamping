package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    // C
    public void addClient(Client client) {
        clientRepository.save(client);
    }




    // R
    public List<Client> getClientAllByIdAndPassword(String id, String password){
        return clientRepository.getAllByClientIdAndClientPassword(id, password);
    }

    public Client getClient(String clientId){
        return clientRepository.getClientByClientId(clientId);
    }

    public Optional<Client> getClientById(String id) {
        Optional<Client> result = clientRepository.findById(id);

        return result;
    }
    // U

    // D

}
