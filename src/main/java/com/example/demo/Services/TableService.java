package com.example.demo.Services;

import com.example.demo.DTO.Table.TableReponse;
import com.example.demo.DTO.Table.TableRequest;
import com.example.demo.Models.TableEntity;
import org.hibernate.mapping.Table;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
@Service
public interface TableService {

    List<TableReponse> getAllEntity();
    TableReponse getEntityById(long id);
    TableReponse addTable(TableRequest entity);
    TableReponse updateTable(long id ,TableRequest newEntity);
    String deleteTable(long id );


}


