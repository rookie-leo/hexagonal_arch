package com.hexagonal.adapters.out

import com.hexagonal.adapters.out.repository.CustomerRepository
import com.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper
import com.hexagonal.application.core.domain.Customer
import com.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository,
    private val customerEntityMapper: CustomerEntityMapper
) : FindCustomerByIdOutputPort {

    override fun find(id: String): Optional<Customer> {
        return customerRepository.findById(id)
            .map { customerEntityMapper.toCustomer(it) }
    }
}