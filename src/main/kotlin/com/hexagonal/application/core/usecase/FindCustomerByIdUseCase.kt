package com.hexagonal.application.core.usecase

import com.hexagonal.application.core.domain.Customer
import com.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
) : FindCustomerByIdInputPort {

    override fun find(id: String): Customer {
        return findCustomerByIdOutputPort.find(id)
            .orElseThrow { throw RuntimeException("Customer not found") }
    }

}