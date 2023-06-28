package com.example.acasadobacalhau.controller.requests.tables

import com.example.acasadobacalhau.enums.TableStatus

data class PutTableRequest(
    val id: Int?,
    val number: Int?,
    val capacity: Int?,
    val status: TableStatus?
)
