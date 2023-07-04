package com.example.acasadobacalhau.controller.requests.order

import com.fasterxml.jackson.annotation.JsonAlias
import java.time.LocalTime

data class PutOrderRequest(
    val schedule: LocalTime?,
    @JsonAlias("reservation_id")
    val reservation: Int?,
    @JsonAlias("employee_id")
    val employee: Int?,
    @JsonAlias("customer_id")
    val customer: Int?
    )
