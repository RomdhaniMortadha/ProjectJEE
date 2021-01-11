package com.example.demo.Services;

import com.example.demo.DTO.Met.MetReponse;
import com.example.demo.DTO.Met.MetRequest;
import com.example.demo.Models.Met.MetEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MetService {

    List<MetReponse> getAllEntity();
    List<MetReponse> getAllPlats();
    List<MetReponse> getAllDesserts();
    List<MetReponse> getAllEntrees();
    MetReponse getEntityById(long id);
    //MetReponse addMet(MetRequest entity);
    MetReponse addPlat(MetRequest entityeq);
    MetReponse addEntree(MetRequest entityeq);
    MetReponse addDessert(MetRequest entityeq);
    MetReponse updateMet(long id , MetRequest newEntity);
    String deleteMet(long id );
}
