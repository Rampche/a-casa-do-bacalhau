package com.example.acasadobacalhau.extensions

import com.example.acasadobacalhau.controller.requests.customer.PostCustomerRequest
import com.example.acasadobacalhau.controller.requests.customer.PutCustomerRequest
import com.example.acasadobacalhau.controller.requests.employee.PostEmployeeRequest
import com.example.acasadobacalhau.controller.requests.employee.PutEmployeeRequest
import com.example.acasadobacalhau.controller.requests.order.PostOrderRequest
import com.example.acasadobacalhau.controller.requests.order.PutOrderRequest
import com.example.acasadobacalhau.controller.requests.reservation.PostReservationRequest
import com.example.acasadobacalhau.controller.requests.reservation.PutReservationRequest
import com.example.acasadobacalhau.controller.requests.tables.PostTableRequest
import com.example.acasadobacalhau.controller.requests.tables.PutTableRequest
import com.example.acasadobacalhau.controller.response.CustomerResponse
import com.example.acasadobacalhau.models.*

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
return CustomerModel(name = this.name, email=this.email, password = this.password)
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel ):CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name ?: previousValue.name, email=this.email ?: previousValue.email, password = this.password ?: previousValue.password)
}

fun CustomerModel.toResponse() : CustomerResponse {
    return CustomerResponse(
        id = this.id!!,
        name = this.name,
        email = this.email,
    )
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
    return TableModel(id = previousValue.id, number = this.number ?: previousValue.number, capacity = this.capacity ?: previousValue.capacity, status = this.status ?: previousValue.status)
}

fun PostReservationRequest.toReservationModel(customer: CustomerModel, table: TableModel):ReservationModel{
    return ReservationModel(date = this.date, time = this.time, partySize = this.partySize, customer = customer, table = table)
}

fun PutReservationRequest.toReservationModel(previousValue: ReservationModel, previousTable: TableModel):ReservationModel{
    return ReservationModel(id = previousValue.id, date = this.date ?: previousValue.date, time = this.time ?: previousValue.time, partySize = this.partySize ?: previousValue.partySize, table = previousTable, customer = previousValue.customer)
}

fun PostOrderRequest.toOrderModel(employee: EmployeeModel, customer: CustomerModel, reservation: ReservationModel):OrderModel{
    return OrderModel(schedule = this.schedule, reservation = reservation, employee = employee, customer = customer)
}

fun PutOrderRequest.toOrderModel(previousValue: OrderModel):OrderModel{
    return OrderModel(id = previousValue.id, schedule = this.schedule ?: previousValue.schedule , customer = this.customer as? CustomerModel ?: previousValue.customer, reservation = this.reservation as? ReservationModel?: previousValue.reservation, employee = this.employee as? EmployeeModel ?: previousValue.employee)
}