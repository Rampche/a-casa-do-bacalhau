package com.example.acasadobacalhau.extensions

import com.example.acasadobacalhau.controller.requests.customer.PostCustomerRequest
import com.example.acasadobacalhau.controller.requests.customer.PutCustomerRequest
import com.example.acasadobacalhau.controller.requests.employee.PostEmployeeRequest
import com.example.acasadobacalhau.controller.requests.employee.PutEmployeeRequest
import com.example.acasadobacalhau.controller.requests.reservation.PostReservationRequest
import com.example.acasadobacalhau.controller.requests.reservation.PutReservationRequest
import com.example.acasadobacalhau.controller.requests.tables.PostTableRequest
import com.example.acasadobacalhau.controller.requests.tables.PutTableRequest
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.models.EmployeeModel
import com.example.acasadobacalhau.models.ReservationModel
import com.example.acasadobacalhau.models.TableModel

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

fun PostTableRequest.toTableModel(): TableModel{
    return TableModel(id = this.id, number = this.number, capacity = this.capacity, status = this.status)
}

fun PutTableRequest.toTableModel(previousValue: TableModel): TableModel{
    return TableModel(id = previousValue.id, number = previousValue.number, capacity = previousValue.capacity, status = previousValue.status)
}

fun PostReservationRequest.toReservationModel(customer: CustomerModel, table: TableModel):ReservationModel{
    return ReservationModel(date = this.date, time = this.time, partySize = this.partySize, customer = customer, table = table)
}

fun PutReservationRequest.toReservationModel(previousValue: ReservationModel):ReservationModel{
    return ReservationModel(id = previousValue.id, date = previousValue.date, time = previousValue.time, partySize = previousValue.partySize, customer = previousValue.customer, table = previousValue.table)
}