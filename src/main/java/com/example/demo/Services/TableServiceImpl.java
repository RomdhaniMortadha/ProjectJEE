package com.example.demo.Services;

import com.example.demo.Models.TableEntity;
import com.example.demo.Reposetories.TableRebository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class TableServiceImpl implements TableService {

    private TableRebository tableRebository;

    @Autowired
    public TableServiceImpl(TableRebository tableRebository) {
        super();
        this.tableRebository = tableRebository;
    }

    @Override
    public List<TableEntity> getAllEntity() {
        return tableRebository.findAll();
    }

    @Override
    public TableEntity getEntityById(long id) {
        Optional<TableEntity> opt = tableRebository.findById(id);
        TableEntity entity;
        if (opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Table with this Id is not found");
        return entity;
    }

    @Override
    public TableEntity addTable(TableEntity entity) {
        return tableRebository.save(entity);
    }

    @Override
    public TableEntity updateTable(long id, TableEntity newEntity) {
        TableEntity table =this.getEntityById(id);
        if ( newEntity.getNumero() != 0)
            table.setNumero(newEntity.getNumero());

        if ( newEntity.getNbCouverrt() != 0)
            table.setNbCouverrt(newEntity.getNbCouverrt());

        if ( newEntity.getType() != null)
            table.setType(newEntity.getType());

        if ( newEntity.getSupplement() != 0)
            table.setSupplement(newEntity.getSupplement());

        return table;
    }

    @Override
    public String deleteTable(long id) {
        TableEntity table = this.getEntityById(id);
        tableRebository.deleteById(id);
        return "table deleted";
    }

}
