package com.example.acasadobacalhau.repository

import com.example.acasadobacalhau.enums.CustomerStatus
import com.example.acasadobacalhau.enums.EmployeeStatus
import com.example.acasadobacalhau.enums.RoleType
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.models.EmployeeModel
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository:CrudRepository<EmployeeModel, Int> {
    fun findByNameContaining(name: String): List<EmployeeModel>
    fun findByRole(type: RoleType): List<EmployeeModel>
    fun findByStatus(status: EmployeeStatus): List<EmployeeModel>
}