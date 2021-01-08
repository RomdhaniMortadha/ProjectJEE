package com.example.demo.Services;

import com.example.demo.DTO.Client.ClientReponse;
import com.example.demo.DTO.Client.ClietnRequest;
import com.example.demo.Models.ClientEntity;


import java.util.List;

public interface ClientService {
    List<ClientReponse> getAllEntity();
    ClientReponse getEntityById(long id);
    ClientReponse addClient(ClietnRequest entity);
    ClientReponse updateClient(long id ,ClietnRequest newEntity);
    String deleteClient(long id );


}
