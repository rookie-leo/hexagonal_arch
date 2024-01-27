package com.hexagonal.application.ports.`in`

import com.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer

}