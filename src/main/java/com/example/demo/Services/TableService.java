package com.example.demo.Services;

import com.example.demo.Models.TableEntity;
import org.hibernate.mapping.Table;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
@Service
public interface TableService {

    List<TableEntity> getAllEntity();
    TableEntity getEntityById(long id);
    TableEntity addTable(TableEntity entity);
    TableEntity updateTable(long id ,TableEntity newEntity);
    String deleteTable(long id );


}


