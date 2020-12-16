package com.example.demo.Services;

import com.example.demo.Models.ClientEntity;
import com.example.demo.Reposetories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class ClientServiceImpl implements  ClientService{

    private ClientRepository clietnRepository;

    public ClientServiceImpl(ClientRepository clietnRebository) {
        super();
        this.clietnRepository = clietnRebository;
    }

    @Override
    public List<ClientEntity> getAllEntity() {
        return  clietnRepository.findAll();
    }

    @Override
    public ClientEntity getEntityById(long id) {
        Optional<ClientEntity> opt = clietnRepository.findById(id);
        ClientEntity entity;
        if (opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Client with this Id is not found");
        return entity;

    }

    @Override
    public ClientEntity addClient(ClientEntity entity) {
        return clietnRepository.save(entity);
    }

    @Override
    public ClientEntity updateClient(long id, ClientEntity newEntity) {
        ClientEntity client =this.getEntityById(id);
        if ( newEntity.getNom() != null)
            client.setNom(newEntity.getNom());

        if ( newEntity.getPrenom() != null)
            client.setPrenom(newEntity.getPrenom());

        if ( newEntity.getDateDeNaissance() != null)
            client.setDateDeNaissance(newEntity.getDateDeNaissance());

        if ( newEntity.getCourriel() != null)
            client.setCourriel(newEntity.getCourriel());

        if ( newEntity.getTelephone() != null)
            client.setTelephone(newEntity.getTelephone());

        return client;
    }

    @Override
    public String deleteClient(long id) {
        ClientEntity client = this.getEntityById(id);
        clietnRepository.deleteById(id);
        return "client delted ! ";
    }
}
