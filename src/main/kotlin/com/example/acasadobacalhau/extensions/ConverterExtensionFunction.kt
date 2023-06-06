package com.example.acasadobacalhau.extensions

import com.example.acasadobacalhau.controller.requests.PatchCustomerRequest
import com.example.acasadobacalhau.controller.requests.PostCustomerRequest
import com.example.acasadobacalhau.controller.requests.PutCustomerRequest
import com.example.acasadobacalhau.models.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
return CustomerModel(name = this.name, email=this.email, password = this.password)
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel ):CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name ?: previousValue.name, email=this.email ?: previousValue.email, password = this.password ?: previousValue.password)
}