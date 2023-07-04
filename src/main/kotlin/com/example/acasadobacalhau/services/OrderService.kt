package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.enums.CustomerStatus
import com.example.acasadobacalhau.enums.Errors
import com.example.acasadobacalhau.exception.NotFoundException
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.models.OrderModel
import com.example.acasadobacalhau.repository.CustomerRepository
import com.example.acasadobacalhau.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(val orderRepository: OrderRepository) {

    //Create a new order
    fun createOrder(order: OrderModel){
        orderRepository.save(order)
    }

    //List the orders
    fun findOrders(): List<OrderModel> {
        return orderRepository.findAll().toList()
    }

    //List order by Id
    fun findOrderById(id: Int): OrderModel{
        if (!orderRepository.existsById(id)){
            throw NotFoundException(Errors.VG0006.message.format(id), Errors.VG0006.code)
        }
        return orderRepository.findById(id).orElseThrow()
    }

    //Update order
    fun updateOrder(order: OrderModel) {
        if (!orderRepository.existsById(order.id!!)){
            throw NotFoundException(Errors.VG0006.message.format(order.id), Errors.VG0006.code)
        }
        orderRepository.save(order)
    }

    //Delete Customer
    fun deleteOrder(id: Int) {
        if (!orderRepository.existsById(id)){
            throw NotFoundException(Errors.VG0006.message.format(id), Errors.VG0006.code)
        }
        orderRepository.deleteById(id)

    }
}