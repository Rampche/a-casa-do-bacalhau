package com.example.acasadobacalhau.controller

import com.example.acasadobacalhau.controller.requests.order.PostOrderRequest
import com.example.acasadobacalhau.controller.requests.order.PutOrderRequest
import com.example.acasadobacalhau.extensions.toOrderModel
import com.example.acasadobacalhau.models.OrderModel
import com.example.acasadobacalhau.services.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/orders")
class OrderController(val orderService: OrderService, val reservationService: ReservationService,val customerService: CustomerService, val employeeService: EmployeeService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@RequestBody order: PostOrderRequest){
        val employee = employeeService.findEmployeeById(order.employee)
        val customer = customerService.findCustomerById(order.customer)
        val reservation = reservationService.findReservationById(order.reservation)
        orderService.createOrder(order.toOrderModel(employee, customer, reservation))
    }
//REVER ESSA PARTE
    @GetMapping
    fun findOrders(): List<OrderModel>{
        return orderService.findOrders()
    }

    @GetMapping("/{id}")
    fun findOrderById(@PathVariable id: Int):OrderModel{
        return orderService.findOrderById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateOrder(@PathVariable id: Int, @RequestBody order: PutOrderRequest){
        val orderSaved = orderService.findOrderById(id)
        orderService.updateOrder(order.toOrderModel((orderSaved)))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteOrder(@PathVariable id: Int){
        orderService.deleteOrder(id)
    }
}