package com.hexagonal.application.ports.out

import com.hexagonal.application.core.domain.Customer

interface InsertCustomerOutputPort {

    fun insert(customer: Customer)

}