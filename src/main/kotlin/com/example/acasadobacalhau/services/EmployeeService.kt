package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.enums.EmployeeStatus
import com.example.acasadobacalhau.enums.Errors
import com.example.acasadobacalhau.enums.RoleType
import com.example.acasadobacalhau.exception.NotFoundException
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
        val activeEmployee = EmployeeStatus.ACTIVE
        if (!employeeRepository.existsByStatus(EmployeeStatus.ACTIVE)){
            throw NotFoundException(Errors.VG0007.message.format(activeEmployee.toString()), Errors.VG0007.code)
        }
        return employeeRepository.findByStatus(EmployeeStatus.ACTIVE)
    }

    //Find all dismisseds employees
    fun findDismisseds(): List<EmployeeModel> {
        val dismissedEmployee = EmployeeStatus.DISMISSED
        if (!employeeRepository.existsByStatus(EmployeeStatus.DISMISSED)){
            throw NotFoundException(Errors.VG0007.message.format(dismissedEmployee.toString()), Errors.VG0007.code)
        }
        return employeeRepository.findByStatus(EmployeeStatus.DISMISSED)
    }

    //Find by Role
    fun findByRole(type: RoleType): List<EmployeeModel> {
        return employeeRepository.findByRole(type)
    }

    //Find Employee by Id
    fun findEmployeeById(id: Int): EmployeeModel {
        if (!employeeRepository.existsById(id)){
            throw NotFoundException(Errors.VG0004.message.format(id), Errors.VG0004.code)
        }
        return employeeRepository.findById(id).orElseThrow()
    }

    //Update Employee
    fun updateEmployee(employee: EmployeeModel) {
        if (!employeeRepository.existsById(employee.id!!)){
            throw NotFoundException(Errors.VG0004.message.format(employee.id), Errors.VG0004.code)
        }
        employeeRepository.save(employee)
    }

    //Delete Employee
    fun deleteEmployee(id: Int) {
        if (!employeeRepository.existsById(id)){
            throw NotFoundException(Errors.VG0004.message.format(id), Errors.VG0004.code)
        }
        val employee = findEmployeeById(id)
        employee.status = EmployeeStatus.DISMISSED
        updateEmployee(employee)
    }

}