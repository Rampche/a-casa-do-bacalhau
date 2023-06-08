package com.example.acasadobacalhau.repository


import com.example.acasadobacalhau.models.TableModel
import org.springframework.data.repository.CrudRepository

interface TableRepository:CrudRepository<TableModel, Int> {
    
}