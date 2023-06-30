package com.example.acasadobacalhau.services.seeds


import com.example.acasadobacalhau.enums.CustomerStatus
import com.example.acasadobacalhau.enums.TableStatus
import com.example.acasadobacalhau.models.CustomerModel
import com.example.acasadobacalhau.models.ReservationModel
import com.example.acasadobacalhau.models.TableModel
import com.example.acasadobacalhau.repository.CustomerRepository
import com.example.acasadobacalhau.repository.ReservationRepository
import com.example.acasadobacalhau.repository.TableRepository
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.context.annotation.DependsOn
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
@ConditionalOnExpression("\${seeding.enable:false}")
@DependsOn("customerSeedService", "tableSeedService")
class ReservationSeedService(
    private val customerRepository: CustomerRepository,
    private val tableRepository: TableRepository,
    private val reservationRepository: ReservationRepository
) {
    @PostConstruct
    fun seedReservations() {
        val customers = customerRepository.findAll()
        val tables = tableRepository.findAll()

        val reservations = listOf(
            ReservationModel(
                date = LocalDate.now().plusDays(1),
                time = LocalTime.of(18, 30),
                partySize = 4,
                customer = CustomerModel(1, "Bruna de Freitas", "bruna.freitas@email.com", "123456", CustomerStatus.ACTIVE),
                table = TableModel(1, 1, 4, TableStatus.EMPTY),
            ),
            ReservationModel(
                date = LocalDate.now().plusDays(2),
                time = LocalTime.of(20, 0),
                partySize = 2,
                customer = CustomerModel(2, "Maria Luiza", "maria.luiza@email.com", "123455454", CustomerStatus.ACTIVE),
                table = TableModel(2, 2, 6, TableStatus.EMPTY),
            ),
            ReservationModel(
                date = LocalDate.now().plusDays(3),
                time = LocalTime.of(19, 0),
                partySize = 6,
                customer = CustomerModel(3, "Daniel Rodrigues", "daniel.rodrigues@email.com","12321",CustomerStatus.ACTIVE),
                table = TableModel(3, 3, 8, TableStatus.EMPTY),
            )
        )

        reservationRepository.saveAll(reservations)
    }
}
