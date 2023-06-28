package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.enums.CustomerStatus
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.models.TableModel
import com.example.acasadobacalhau.repository.TableRepository
import org.springframework.stereotype.Service

@Service
class TablesService(val tableRepository: TableRepository) {


    //Create a new table
    fun createTable(table: TableModel){
        tableRepository.save(table)
    }

    //Find table by Id
    fun findTableById(id: Int): TableModel {
        return tableRepository.findById(id).orElseThrow()
    }

    //Find all tables
    fun getAllTables(): List<TableModel>{
        return tableRepository.findAll().toList()
    }

    //Update table
    fun updateTable(table: TableModel) {
        tableRepository.save(table)
    }

    //Delete table
    fun deleteTable(id: Int) {
        val table = findTableById(id)
        updateTable(table)

    }


}