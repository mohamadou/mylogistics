package com.mohamadou.mylogistics.rest;

import com.mohamadou.mylogistics.entity.Client;
import com.mohamadou.mylogistics.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private  ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientController() {
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getClients();
    }

    @GetMapping(path = "{clientId}")
    public Client getClient(@PathVariable Long clientId) {

        return  clientService.getClientById(clientId);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client client) {
        return  clientService.updateClient(client);
    }

    @DeleteMapping(path = "{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
    }
}
