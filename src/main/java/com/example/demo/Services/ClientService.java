package com.example.demo.Services;

import com.example.demo.Models.ClientEntity;


import java.util.List;

public interface ClientService {
    List<ClientEntity> getAllEntity();
    ClientEntity getEntityById(long id);
    ClientEntity addClient(ClientEntity entity);
    ClientEntity updateClient(long id , ClientEntity newEntity);
    String deleteClient(long id );


}
