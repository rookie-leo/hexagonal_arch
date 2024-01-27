package com.hexagonal.adapters.out

import com.hexagonal.adapters.out.repository.CustomerRepository
import com.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper
import com.hexagonal.application.core.domain.Customer
import com.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository,
    private val customerEntityMapper: CustomerEntityMapper
) : UpdateCustomerOutputPort {

    override fun update(customer: Customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer))
    }

}