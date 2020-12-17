package com.example.demo.Services;

import com.example.demo.Models.Met.MetEntity;
import com.example.demo.Reposetories.MetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class MetServiceImpl implements MetService {
    private MetRepository metRepository;

    public MetServiceImpl(MetRepository metRepository) {
        super();
        this.metRepository = metRepository;
    }

    @Override
    public List<MetEntity> getAllEntity() {
        return  metRepository.findAll();
    }

    @Override
    public MetEntity getEntityById(long id) {
        Optional<MetEntity> opt = metRepository.findById(id);
        MetEntity entity;
        if (opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Met with this Id is not found");
        return entity;    }

    @Override
    public MetEntity addMet(MetEntity entity) {
        return metRepository.save(entity);    }

    @Override
    public MetEntity updateMet(long id, MetEntity newEntity) {
        MetEntity met =this.getEntityById(id);
        if ( newEntity.getNom() != null)
            met.setNom(newEntity.getNom());

        if ( newEntity.getPrix() != 0)
            met.setPrix(newEntity.getPrix());
        return met;    }

    @Override
    public String deleteMet(long id) {
        MetEntity met = this.getEntityById(id);
        metRepository.deleteById(id);
        return "Met delted ! ";    }
}
