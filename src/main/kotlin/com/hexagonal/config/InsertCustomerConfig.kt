package com.hexagonal.config

import com.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.hexagonal.adapters.out.InsertCustomerAdapter
import com.hexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomerUseCase(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insetCustomerAdapter: InsertCustomerAdapter
    ): InsertCustomerUseCase {
        return InsertCustomerUseCase(findAddressByZipCodeAdapter, insetCustomerAdapter)
    }

}