package com.example.acasadobacalhau.services.seeds

import com.example.acasadobacalhau.enums.CustomerStatus
import com.example.acasadobacalhau.enums.RoleType
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.repository.CustomerRepository
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
@Service
class CustomerSeedService@Autowired constructor(
    private val customerRepository: CustomerRepository
) {
    @PostConstruct
    fun seedCustomers(){
        val customers = listOf(
            CustomerModel(1, "Bruna de Freitas", "bruna.freitas@email.com", "123456", CustomerStatus.ACTIVE),
            CustomerModel(2, "Maria Luiza", "maria.luiza@email.com", "123455454", CustomerStatus.ACTIVE),
            CustomerModel(3, "Daniel Rodrigues", "daniel.rodrigues@email.com","12321",CustomerStatus.ACTIVE)
        )
        customerRepository.saveAll(customers)
    }
}
