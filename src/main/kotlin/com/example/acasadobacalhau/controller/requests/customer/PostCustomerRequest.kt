package com.example.acasadobacalhau.controller.requests.customer

data class PostCustomerRequest(
    val name: String,
    val email: String,
    val password: String
)