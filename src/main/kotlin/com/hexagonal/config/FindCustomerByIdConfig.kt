package com.hexagonal.config

import com.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerByIdUseCase(findCustomerByIdAdapter: FindCustomerByIdAdapter): FindCustomerByIdUseCase {
        return FindCustomerByIdUseCase(findCustomerByIdAdapter)
    }

}