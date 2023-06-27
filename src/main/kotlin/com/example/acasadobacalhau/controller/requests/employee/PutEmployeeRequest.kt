package com.example.acasadobacalhau.controller.requests.employee

import com.example.acasadobacalhau.enums.RoleType

data class PutEmployeeRequest(
    var name: String?,
    var email: String?,
    var password: String?,
    var role: RoleType?
)
