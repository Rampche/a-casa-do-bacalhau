package com.example.acasadobacalhau.controller.requests.employee

import com.example.acasadobacalhau.enums.RoleType

data class PostEmployeeRequest (

    val name: String,
    val email: String,
    val password: String,
    val role: RoleType
)