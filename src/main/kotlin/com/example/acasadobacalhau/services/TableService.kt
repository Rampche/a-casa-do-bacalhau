package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.enums.TableStatus
import com.example.acasadobacalhau.models.TableModel
import com.example.acasadobacalhau.repository.TableRepository
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TableService @Autowired constructor (
    private val tableRepository: TableRepository
){
    @PostConstruct
    fun seedTables() {
        val tables = listOf(
            TableModel(1, 1, 4, TableStatus.EMPTY),
            TableModel(2, 2, 6, TableStatus.EMPTY),
            TableModel(3, 3, 8, TableStatus.EMPTY),
            TableModel(4, 4, 4, TableStatus.EMPTY),
            TableModel(5, 5, 2, TableStatus.EMPTY)
        )
        tableRepository.saveAll(tables)
    }

}