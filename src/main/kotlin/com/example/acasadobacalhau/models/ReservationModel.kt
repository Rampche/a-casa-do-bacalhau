package com.example.acasadobacalhau.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity(name="reservation")
data class ReservationModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "reservation_id")
    var id: Int? = null,
    @Column(name="reservation_date")
    var date: LocalDate,
    @Column(name = "reservation_time")
    var time: LocalTime,
    @Column(name="party_size")
    var partySize: Int,

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="customer_id")
    var customer: CustomerModel? = null,

    @ManyToOne
    @JoinColumn(name= "tables_id")
    var table: TableModel? = null
)
