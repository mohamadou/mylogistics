package com.mohamadou.mylogistics.service;

import com.mohamadou.mylogistics.entity.Client;
import com.mohamadou.mylogistics.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientById(Long id) {
        return  clientRepository.getById(id);
    }

    public List<Client> getClients() {
        return  clientRepository.findAll();
    }


    public Client createClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());

        client.setId(0L);

        if(clientOptional.isPresent()) {
            throw new IllegalStateException("Email taken");

        }

        return clientRepository.save(client);
    }


    public Client updateClient(Client client){
        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);

        if (clientOptional.isEmpty()) {
            throw new IllegalStateException("Client does not exist");
        }
        clientRepository.deleteById(clientId);
    }
}
