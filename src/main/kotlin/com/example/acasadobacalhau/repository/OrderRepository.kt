package com.example.acasadobacalhau.repository

import com.example.acasadobacalhau.models.OrderModel
import org.springframework.data.repository.CrudRepository

interface OrderRepository:CrudRepository<OrderModel, Int> {
}