package com.example.acasadobacalhau.extensions

import com.example.acasadobacalhau.controller.requests.customer.PostCustomerRequest
import com.example.acasadobacalhau.controller.requests.customer.PutCustomerRequest
import com.example.acasadobacalhau.controller.requests.employee.PostEmployeeRequest
import com.example.acasadobacalhau.controller.requests.employee.PutEmployeeRequest
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.models.EmployeeModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
return CustomerModel(name = this.name, email=this.email, password = this.password)
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel ):CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name ?: previousValue.name, email=this.email ?: previousValue.email, password = this.password ?: previousValue.password)
}


fun PostEmployeeRequest.toEmployeeModel():EmployeeModel{
    return EmployeeModel(name = this.name,  email=this.email, password = this.password, role = this.role)
}

fun PutEmployeeRequest.toEmployeeModel(previousValue: EmployeeModel ):EmployeeModel {
    return EmployeeModel(id = previousValue.id, name = this.name ?: previousValue.name, email=this.email ?: previousValue.email, password = this.password ?: previousValue.password, role = this.role ?: previousValue.role)
}