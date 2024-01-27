package com.hexagonal.application.core.usecase

import com.hexagonal.application.core.domain.Customer
import com.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort
) : UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        findCustomerByIdInputPort.find(customer.id)
        val address = findAddressByZipCodeOutputPort.find(zipCode)
        customer.address = address
        updateCustomerOutputPort.update(customer)
    }

}