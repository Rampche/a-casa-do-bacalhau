package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.enums.EmployeeStatus
import com.example.acasadobacalhau.enums.RoleType
import com.example.acasadobacalhau.models.EmployeeModel
import com.example.acasadobacalhau.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(val employeeRepository: EmployeeRepository) {

    //Create a new Employee
    fun createEmployee(employee: EmployeeModel) {
        employeeRepository.save(employee)
    }

    //Show all Employees
    fun getAllEmployees(name: String?): List<EmployeeModel> {
        name?.let { return employeeRepository.findByNameContaining(it) }
        return employeeRepository.findAll().toList()
    }

    //Find all Actives
    fun findActives(): List<EmployeeModel> {
        return employeeRepository.findByStatus(EmployeeStatus.ACTIVE)
    }

    //Find all dismisseds employees
    fun findDismisseds(): List<EmployeeModel> {
        return employeeRepository.findByStatus(EmployeeStatus.DISMISSED)
    }

    //Find by Role
    fun findByRole(type: RoleType): List<EmployeeModel> {
        return employeeRepository.findByRole(type)
    }

    //Find Employee by Id
    fun findEmployeeById(id: Int): EmployeeModel {
        return employeeRepository.findById(id).orElseThrow()
    }

    //Update Employee
    fun updateEmployee(employee: EmployeeModel) {
        employeeRepository.save(employee)
    }

    //Delete Employee
    fun deleteEmployee(id: Int) {
        val employee = findEmployeeById(id)
        employee.status = EmployeeStatus.DISMISSED
        updateEmployee(employee)
    }

}