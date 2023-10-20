package com.platzi.market.persistence.crud;

import com.platzi.market.domain.dto.Client;
import com.platzi.market.domain.repository.ClientReporsitory;
import com.platzi.market.domain.repository.ClienteCrudRepository;
import com.platzi.market.persistence.entity.Cliente;
import com.platzi.market.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientReporsitory {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Autowired
    private ClientMapper clientMapper;
    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = clienteCrudRepository.findAll();
        return clientMapper.toClients(clientes);
    }

    @Override
    public Optional<Client> getClient(String clientId) {
        return clienteCrudRepository.findById(clientId).map(cliente -> clientMapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = clientMapper.toCliente(client);
        return clientMapper.toClient(clienteCrudRepository.save(cliente));
    }
    @Override
    public Client updateClient(String clientId, Client client) {
        return getClient(clientId).map(clientToUpdate -> {
            clientToUpdate.setName(client.getName());
            clientToUpdate.setLastName(client.getLastName());
            clientToUpdate.setCellphone(client.getCellphone());
            clientToUpdate.setAddress(client.getAddress());
            clientToUpdate.setEmail(client.getEmail());
            Cliente cliente = clientMapper.toCliente(clientToUpdate);
            return save(clientMapper.toClient(cliente));
        }).orElse(null);
    }

    @Override
    public void delete(String clientId) {
        clienteCrudRepository.deleteById(clientId);
    }
}
