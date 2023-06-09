package com.example.acasadobacalhau.controller

import com.example.acasadobacalhau.controller.requests.employee.PostEmployeeRequest
import com.example.acasadobacalhau.controller.requests.employee.PutEmployeeRequest
import com.example.acasadobacalhau.enums.RoleType
import com.example.acasadobacalhau.extensions.toEmployeeModel
import com.example.acasadobacalhau.models.EmployeeModel
import com.example.acasadobacalhau.services.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("employees")
class EmployeeController(val employeeService: EmployeeService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createEmployee(@RequestBody employee: PostEmployeeRequest){
        employeeService.createEmployee(employee.toEmployeeModel())
    }

    @GetMapping
    fun getAllEmployees(@RequestParam name:String?): List<EmployeeModel>{
        return employeeService.getAllEmployees(name)
    }

    @GetMapping("/actives")
    fun findActives():List<EmployeeModel>{
        return employeeService.findActives()
    }

    @GetMapping("/dismisseds")
    fun findDismisseds():List<EmployeeModel>{
        return employeeService.findDismisseds()
    }

    @GetMapping("/roles")
    fun findByRole(type:RoleType):List<EmployeeModel>{
        return employeeService.findByRole(type)
    }

    @GetMapping("/{id}")
    fun findEmployeeById(@PathVariable id:Int):EmployeeModel{
        return employeeService.findEmployeeById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateEmployee(@PathVariable id:Int, @RequestBody employee: PutEmployeeRequest){
        val employeeSaved = employeeService.findEmployeeById(id)
        return employeeService.updateEmployee(employee.toEmployeeModel(employeeSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEmployee(@PathVariable id: Int){
        return employeeService.deleteEmployee(id)
    }
}