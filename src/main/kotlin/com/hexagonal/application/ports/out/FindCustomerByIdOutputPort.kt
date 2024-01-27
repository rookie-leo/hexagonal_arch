package com.hexagonal.application.ports.out

import com.hexagonal.application.core.domain.Customer
import java.util.Optional

interface FindCustomerByIdOutputPort {

    fun find(id: String): Optional<Customer>

}