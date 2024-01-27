package com.hexagonal.application.ports.`in`

import com.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)

}