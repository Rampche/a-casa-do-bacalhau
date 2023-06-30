package com.example.acasadobacalhau.services.seeds

import com.example.acasadobacalhau.enums.RoleType
import com.example.acasadobacalhau.models.EmployeeModel
import com.example.acasadobacalhau.repository.EmployeeRepository
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.stereotype.Service

@Service
@ConditionalOnExpression("\${seeding.enable:false}")
class EmployeeSeedService(
    private val employeeRepository: EmployeeRepository
){
    @PostConstruct
    fun seedEmployees(){
        val employees = listOf(
            EmployeeModel(1, "Gregório Almeida", "gregorio.almeida@verge.com", RoleType.ADMIN, "123456"),
            EmployeeModel(2, "Pedro José", "pedro.jose@verge.com", RoleType.COMMON, "123455454"),
            EmployeeModel(3, "Alberto Rodrigues", "alberto.rodrigues@verge.com", RoleType.COMMON, "12321")
        )
        employeeRepository.saveAll(employees)
    }
}