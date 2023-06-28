package com.example.acasadobacalhau.controller

import com.example.acasadobacalhau.controller.requests.tables.PostTableRequest
import com.example.acasadobacalhau.controller.requests.tables.PutTableRequest
import com.example.acasadobacalhau.extensions.toTableModel
import com.example.acasadobacalhau.models.TableModel
import com.example.acasadobacalhau.services.TablesService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/tables")
class TableController (val tablesService: TablesService){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTable(@RequestBody table: PostTableRequest){

        tablesService.createTable(table.toTableModel())
    }

    @GetMapping
    fun getAllTables(): List<TableModel> {
        return tablesService.getAllTables()
    }

    @GetMapping("/{id}")
    fun findTableById(@PathVariable id:Int): TableModel {
        return tablesService.findTableById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateTable(@PathVariable id: Int, @RequestBody table: PutTableRequest){
        val tableSaved = tablesService.findTableById(id)
        tablesService.updateTable(table.toTableModel(tableSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTable(@PathVariable id: Int){
        tablesService.deleteTable(id)
    }





}