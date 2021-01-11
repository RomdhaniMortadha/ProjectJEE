package com.example.demo.EndPoints;
import com.example.demo.DTO.Table.TableReponse;
import com.example.demo.DTO.Table.TableRequest;
import com.example.demo.Services.TableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/table")
public class TableRest {

    private TableServiceImpl tableService;

    @Autowired
    public TableRest(TableServiceImpl tableService) {
        super();
        this.tableService = tableService;
    }

    @GetMapping
    public List<TableReponse> getAll(){
        return tableService.getAllEntity();
    }

    @GetMapping("/{id}")
    public TableReponse getById(@PathVariable("id") long id){
        return tableService.getEntityById(id);
    }

    @PostMapping
    public TableReponse addTable(@RequestBody TableRequest table){
        return tableService.addTable(table);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return tableService.deleteTable( id);
    }
    @PostMapping("/{id}")
    public TableReponse updateTable(@PathVariable("id") long id, @RequestBody TableRequest newTable) {
        return tableService.updateTable(id, newTable);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity <String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<String>( e.getMessage(),HttpStatus.NOT_FOUND);
    }


}
