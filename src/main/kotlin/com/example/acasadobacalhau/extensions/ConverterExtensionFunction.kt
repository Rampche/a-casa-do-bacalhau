package com.example.acasadobacalhau.extensions

import com.example.acasadobacalhau.controllers.requests.PostCustomerRequest
import com.example.acasadobacalhau.models.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
return CustomerModel(name = this.name, email=this.email, password = this.password)
}