package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.controller.requests.reservation.PostReservationRequest
import com.example.acasadobacalhau.enums.CustomerStatus
import com.example.acasadobacalhau.enums.EmployeeStatus
import com.example.acasadobacalhau.enums.Errors
import com.example.acasadobacalhau.exception.NotFoundException
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.models.ReservationModel
import com.example.acasadobacalhau.repository.CustomerRepository
import com.example.acasadobacalhau.repository.ReservationRepository
import org.springframework.stereotype.Service

@Service

class CustomerService(
    val customerRepository: CustomerRepository,
    val reservationRepository: ReservationRepository
) {

    //Create a new customer
    fun createCustomer(customer: CustomerModel){
        customerRepository.save(customer)
    }

    //Find all Actives
    fun findActives(): List<CustomerModel> {
        val activeCustomer = EmployeeStatus.ACTIVE
        if (!customerRepository.existsByStatus(CustomerStatus.ACTIVE)){
            throw NotFoundException(Errors.VG0008.message.format(activeCustomer.toString()), Errors.VG0008.code)
        }
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
        if (!reservationRepository.existsById(id)){
            throw NotFoundException(Errors.VG0002.message.format(id), Errors.VG0002.code)
        }
        return customerRepository.findById(id).orElseThrow { NotFoundException(Errors.VG0002.message.format(id), Errors.VG0002.code) }
    }

    //Update customer
    fun updateCustomer(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)){
            throw NotFoundException(Errors.VG0002.message.format(customer.id), Errors.VG0002.code)
        }
        customerRepository.save(customer)
    }


    //Delete Customer
    fun deleteCustomer(id: Int) {
        if (!reservationRepository.existsById(id)){
            throw NotFoundException(Errors.VG0002.message.format(id), Errors.VG0002.code)
        }
        val customer = findCustomerById(id)
        customer.status = CustomerStatus.DELETED
        updateCustomer(customer)

    }
}