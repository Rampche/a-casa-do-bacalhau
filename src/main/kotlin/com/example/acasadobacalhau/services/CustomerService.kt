package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.enums.CustomerStatus
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository) {

    //Create a new customer
    fun createCustomer(customer: CustomerModel){
        customerRepository.save(customer)
    }

    //Find all Actives
    fun findActives(): List<CustomerModel> {
        return customerRepository.findByStatus(CustomerStatus.ACTIVE)
    }

    //Show all customers
    fun getAllCustomers(name: String?): List<CustomerModel>{
        name?.let{
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    //Find customer by Id
    fun findCustomerById(id: Int): CustomerModel{
        return customerRepository.findById(id).orElseThrow()
    }

    //Update customer
    fun updateCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    //Delete Customer
    fun deleteCustomer(id: Int) {
        val customer = findCustomerById(id)
        customer.status = CustomerStatus.DELETED
        updateCustomer(customer)

    }
}