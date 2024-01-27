package com.hexagonal.application.ports.`in`

import com.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)

}