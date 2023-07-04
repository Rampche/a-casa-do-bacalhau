package com.example.acasadobacalhau.exception

class NotFoundException(override val message: String, val errorCode: String): Exception(){

}
