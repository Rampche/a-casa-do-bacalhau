package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository) {

    //Create a new customer
    fun createCustomer(customer: CustomerModel){
        customerRepository.save(customer)
    }

    //Show all customers
    fun getAll(name: String): List<CustomerModel>{
        name?.let{
            return customerRepository.findNameByContaining(it)
        }
        return customerRepository.findAll().toList()
    }

}