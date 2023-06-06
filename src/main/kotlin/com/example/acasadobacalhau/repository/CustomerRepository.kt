package com.example.acasadobacalhau.repository

import com.example.acasadobacalhau.enums.CustomerStatus
import com.example.acasadobacalhau.models.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository:CrudRepository<CustomerModel, Int> {
    fun findByNameContaining(name: String): List<CustomerModel>
    fun findByStatus(status: CustomerStatus): List<CustomerModel>
}