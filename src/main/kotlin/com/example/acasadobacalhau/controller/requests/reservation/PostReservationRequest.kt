package com.example.acasadobacalhau.controller.requests.reservation

import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.models.TableModel
import com.fasterxml.jackson.annotation.JsonAlias
import java.time.LocalDate
import java.time.LocalTime

data class PostReservationRequest (
    val date: LocalDate,
    val time: LocalTime,
    val partySize: Int,
    @JsonAlias("customer_id")
    val customer: Int,
    @JsonAlias("table_id")
    val table: Int
)