package com.example.demo.Services;

import com.example.demo.DTO.Client.ClientReponse;
import com.example.demo.DTO.Table.TableReponse;
import com.example.demo.DTO.Table.TableRequest;
import com.example.demo.Models.ClientEntity;
import com.example.demo.Models.TableEntity;
import com.example.demo.Reposetories.TableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class TableServiceImpl implements TableService {
    ModelMapper mapper = new ModelMapper();
    private TableRepository tableRepository;

    @Autowired
    public TableServiceImpl(TableRepository tableRepository) {
        super();
        this.tableRepository = tableRepository;
    }

    @Override
    public List<TableReponse> getAllEntity() {

        List<TableEntity> tables = tableRepository.findAll();
        List<TableReponse> reponse = new ArrayList<>();
        for (TableEntity table : tables) {
            reponse.add(mapper.map(table, TableReponse.class));
        }
        return reponse;
    }

    @Override
    public TableReponse getEntityById(long id) {
        Optional<TableEntity> opt = tableRepository.findById(id);
        TableEntity entity;
        if (opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Table with this Id is not found");
        return mapper.map(entity,TableReponse.class);
    }

    @Override
    public TableReponse addTable(TableRequest entityreq) {

        TableEntity table=mapper.map(entityreq,TableEntity.class);
        TableEntity tableinBase=tableRepository.save(table);

        return mapper.map(tableinBase,TableReponse.class);    }

    @Override
    public TableReponse updateTable(long id, TableRequest newEntityreq) {

        TableEntity newEntity =mapper.map(newEntityreq,TableEntity.class );

        TableReponse tablerep =this.getEntityById(id);
        TableEntity table =mapper.map(tablerep,TableEntity.class);

        if ( newEntity.getNumero() != 0)
            table.setNumero(newEntity.getNumero());

        if ( newEntity.getNbCouverrt() != 0)
            table.setNbCouverrt(newEntity.getNbCouverrt());

        if ( newEntity.getType() != null)
            table.setType(newEntity.getType());

        if ( newEntity.getSupplement() != 0)
            table.setSupplement(newEntity.getSupplement());

        TableEntity tablesv=tableRepository.save(table);
        return mapper.map(tablesv,TableReponse.class);
    }

    @Override
    public String deleteTable(long id) {
        TableReponse table = this.getEntityById(id);
        tableRepository.deleteById(id);
        return "table deleted";
    }

}
