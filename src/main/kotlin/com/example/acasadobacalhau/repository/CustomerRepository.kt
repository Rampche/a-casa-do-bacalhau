package com.example.acasadobacalhau.repository

import com.example.acasadobacalhau.models.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository:CrudRepository<CustomerModel, Int> {
    fun findNameByContaining(name: String): List<CustomerModel>
}