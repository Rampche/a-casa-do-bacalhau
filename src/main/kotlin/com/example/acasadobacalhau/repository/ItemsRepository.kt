package com.example.acasadobacalhau.repository


import com.example.acasadobacalhau.models.ItemsModel
import org.springframework.data.repository.CrudRepository

interface ItemsRepository:CrudRepository<ItemsModel, Int> {
    
}