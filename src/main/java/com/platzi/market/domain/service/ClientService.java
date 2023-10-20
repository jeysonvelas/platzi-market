package com.platzi.market.domain.service;

import com.platzi.market.domain.dto.Client;
import com.platzi.market.domain.repository.ClientReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientReporsitory clientReporsitory;

    public List<Client> getAll(){
        return clientReporsitory.getAll();
    }

    public Optional<Client> getClient(String clientId){
        return clientReporsitory.getClient(clientId);
    }

    public Client save(Client client){
        return clientReporsitory.save(client);

    }

    public Client updateClient(String clientId, Client client){
        return clientReporsitory.updateClient(clientId, client);
    }

    public boolean delete(String clientId){
        return getClient(clientId).map(client -> {
            clientReporsitory.delete(clientId);
            return true;
        }).orElse(false);

    }

}
