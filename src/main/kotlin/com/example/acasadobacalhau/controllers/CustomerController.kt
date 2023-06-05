package com.example.acasadobacalhau.controllers.requests

import com.example.acasadobacalhau.extensions.toCustomerModel
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("customers")
class CustomerController(val customerService: CustomerService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest){
        customerService.createCustomer(customer.toCustomerModel())
    }

    @GetMapping
    fun getAll(@RequestParam name:String): List<CustomerModel> {
        return customerService.getAll(name)
    }
}