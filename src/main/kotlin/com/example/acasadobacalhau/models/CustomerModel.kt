package com.example.acasadobacalhau.models

import com.example.acasadobacalhau.enums.CustomerStatus
import jakarta.persistence.*

@Entity(name = "customer")
data class CustomerModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    var id: Int? = null,
    @Column(name= "name")
    var name: String,
    @Column(name= "email")
    var email: String,
    @Column(name= "password")
    var password: String,
    @Column(name= "status")
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus? = CustomerStatus.ACTIVE
)