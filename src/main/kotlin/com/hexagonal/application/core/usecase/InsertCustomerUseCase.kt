package com.hexagonal.application.core.usecase

import com.hexagonal.application.core.domain.Customer
import com.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.application.ports.out.InsertCustomerOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort
) : InsertCustomerInputPort {
    override fun insert(customer: Customer, zipCode: String) {
        val address = findAddressByZipCodeOutputPort.find(zipCode)
        customer.address = address
        insertCustomerOutputPort.insert(customer)
    }
}