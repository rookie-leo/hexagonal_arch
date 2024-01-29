package com.hexagonal.config

import com.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.hexagonal.adapters.out.UpdateCustomerAdapter
import com.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.hexagonal.application.core.usecase.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomerUseCase(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter
    ): UpdateCustomerUseCase {
        return UpdateCustomerUseCase(
            findCustomerByIdUseCase,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter
        )
    }

}