package com.hexagonal.adapters.out

import com.hexagonal.adapters.out.repository.CustomerRepository
import com.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper
import com.hexagonal.application.core.domain.Customer
import com.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    val customerRepository: CustomerRepository,
    val customerEntityMapper: CustomerEntityMapper
) : InsertCustomerOutputPort {
    override fun insert(customer: Customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer))
    }
}