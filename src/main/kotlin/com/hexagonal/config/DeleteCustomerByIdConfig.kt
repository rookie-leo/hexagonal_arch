package com.hexagonal.config

import com.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import com.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import com.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerByIdConfig {

    @Bean
    fun deleteCustomerByIdUseCase(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ): DeleteCustomerByIdUseCase {
        return DeleteCustomerByIdUseCase(
            findCustomerByIdUseCase,
            deleteCustomerByIdAdapter
        )
    }
}