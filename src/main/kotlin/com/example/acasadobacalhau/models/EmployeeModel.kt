package com.example.acasadobacalhau.models

import com.example.acasadobacalhau.enums.EmployeeStatus
import com.example.acasadobacalhau.enums.RoleType
import jakarta.persistence.*

@Entity(name = "employee")
data class EmployeeModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    var id: Int? = null,
    @Column(name="name")
    var name: String,
    @Column(name = "email")
    var email: String,
    @Column(name="role")
    @Enumerated(EnumType.STRING)
    var role: RoleType,
    @Column(name = "password")
    var password: String,
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    var status: EmployeeStatus? = EmployeeStatus.ACTIVE
)
