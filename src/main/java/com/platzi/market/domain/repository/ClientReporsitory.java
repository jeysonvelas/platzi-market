package com.platzi.market.domain.repository;

import com.platzi.market.domain.dto.Client;

import java.util.List;
import java.util.Optional;

public interface ClientReporsitory {

    List<Client> getAll();
    Optional<Client> getClient(String clientId);
    Client save(Client client);
    Client updateClient(String clientId, Client client);
    void delete(String clientId);

}
