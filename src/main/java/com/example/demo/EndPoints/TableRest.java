package com.example.demo.EndPoints;

import com.example.demo.Reposetories.TableRebository;
import com.example.demo.Services.TableService;
import com.example.demo.Models.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/table")
public class TableRest {

    private TableService tableService;

    @Autowired
    public TableRest(TableService tableService) {
        super();
        this.tableService = tableService;
    }

    @GetMapping
    public List<TableEntity> getAll(){
        return tableService.getAllEntity();
    }

    @GetMapping("/{id}")
    public TableEntity getById(@PathVariable("id") long id){
        return tableService.getEntityById(id);
    }

    @PostMapping
    public TableEntity addTable(@RequestBody TableEntity table){
        return tableService.addTable(table);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return tableService.deleteTable( id);
    }
    @PostMapping("/{id}")
    public TableEntity updateTable(@PathVariable("id") long id, @RequestBody TableEntity newTable) {
        return tableService.updateTable(id, newTable);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity <String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<String>( e.getMessage(),HttpStatus.NOT_FOUND);
    }


}
