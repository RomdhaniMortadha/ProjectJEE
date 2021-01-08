package com.example.demo.Services;
import com.example.demo.DTO.Client.ClientReponse;
import com.example.demo.DTO.Client.ClietnRequest;
import com.example.demo.Models.ClientEntity;
import com.example.demo.Reposetories.ClientRep;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClientServiceImpl implements  ClientService{
    private ModelMapper mapper=new ModelMapper();
    private ClientRep clietnRepository;

    public ClientServiceImpl(ClientRep clietnRepository) {
        super();
        this.clietnRepository = clietnRepository;
    }

    @Override
    public List<ClientReponse> getAllEntity() {

        List<ClientEntity> clients = clietnRepository.findAll();
        List<ClientReponse> reponse = new ArrayList<>();
        for (ClientEntity client : clients) {
            reponse.add(mapper.map(client, ClientReponse.class));
        }

        return reponse;
    }
    @Override
    public ClientReponse getEntityById(long id) {
        Optional<ClientEntity> opt = clietnRepository.findById(id);
        ClientEntity entity;
        if (opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Client with this Id is not found");
        return mapper.map(entity,ClientReponse.class);

    }

    @Override
    public ClientReponse addClient(ClietnRequest entityreq) {

        ClientEntity clientRequest=mapper.map(entityreq,ClientEntity.class);
        clientRequest.setNom(clientRequest.getNom().toUpperCase());
        ClientEntity client=clietnRepository.save(clientRequest);

        return mapper.map(client,ClientReponse.class);
    }


    @Override
    public ClientReponse updateClient(long id, ClietnRequest newEntityreq) {

        ClientEntity newEntity =mapper.map(newEntityreq,ClientEntity.class );

        ClientReponse clientrep =this.getEntityById(id);
        ClientEntity client =mapper.map(clientrep,ClientEntity.class);

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
        ClientEntity clientsv=clietnRepository.save(client);
        return mapper.map(clientsv,ClientReponse.class);
    }

    @Override
    public String deleteClient(long id) {
        ClientEntity client = this.getEntityById(id);
        clietnRepository.deleteById(id);
        return "client delted ! ";
    }
}
