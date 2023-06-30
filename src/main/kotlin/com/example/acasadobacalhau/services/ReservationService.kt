package com.example.acasadobacalhau.services

import com.example.acasadobacalhau.models.ReservationModel
import com.example.acasadobacalhau.repository.ReservationRepository
import org.springframework.stereotype.Service

@Service
class ReservationService(val reservationRepository: ReservationRepository) {

    //Create a reservation
    fun createReservation(reservation: ReservationModel){
        reservationRepository.save(reservation)
    }

    //List the reservations
    fun findReservations(): List<ReservationModel>{
        return reservationRepository.findAll().toList()
    }

    //List reservations by id
    fun findReservationById(id: Int):ReservationModel{
        return reservationRepository.findById(id).orElseThrow()
    }

    //Update the reservation
    fun updateReservation(reservation: ReservationModel){
        reservationRepository.save(reservation)
    }

    //Delete the reservation
    fun deleteReservation(id: Int){
        reservationRepository.deleteById(id)
    }


}