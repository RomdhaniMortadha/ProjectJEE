package com.example.demo.Services;

import com.example.demo.Models.Met.MetEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MetService {

    List<MetEntity> getAllEntity();
    MetEntity getEntityById(long id);
    MetEntity addMet(MetEntity entity);
    MetEntity updateMet(long id , MetEntity newEntity);
    String deleteMet(long id );
}
