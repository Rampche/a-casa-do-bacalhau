package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.enums.CustomerStatus
import com.example.acasadobacalhau.enums.Errors
import com.example.acasadobacalhau.exception.NotFoundException
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
        if (!tableRepository.existsById(id)){
            throw NotFoundException(Errors.VG0003.message.format(id), Errors.VG0003.code)
        }
        return tableRepository.findById(id).orElseThrow()
    }

    //Find all tables
    fun getAllTables(): List<TableModel>{
        return tableRepository.findAll().toList()
    }

    //Update table
    fun updateTable(table: TableModel) {
        if (!tableRepository.existsById(table.id!!)){
            throw NotFoundException(Errors.VG0003.message.format(table.id), Errors.VG0003.code)
        }
        tableRepository.save(table)
    }

    //Delete table
    fun deleteTable(id: Int) {
        if (!tableRepository.existsById(id)){
            throw NotFoundException(Errors.VG0003.message.format(id), Errors.VG0003.code)
        }
        val table = findTableById(id)
        updateTable(table)

    }


}