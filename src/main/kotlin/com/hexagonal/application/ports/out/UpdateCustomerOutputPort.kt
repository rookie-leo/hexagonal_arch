package com.hexagonal.application.ports.out

import com.hexagonal.application.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun update(customer: Customer)

}