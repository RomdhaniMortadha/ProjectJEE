package com.example.demo.Services;


import com.example.demo.DTO.Client.ClientReponse;
import com.example.demo.Models.ClientEntity;


import java.util.List;

public interface ClientService {
    List<ClientEntity> getAllEntity();
    ClientReponse getEntityById(long id);
    ClientReponse addClient(ClientRequest entity);
    ClientEntity updateClient(long id , ClientEntity newEntity);
    String deleteClient(long id );


}
