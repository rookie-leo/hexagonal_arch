package com.hexagonal.adapters.`in`.consumer.mapper

import com.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.hexagonal.application.core.domain.Customer
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    fun toCustomer(customerMessage: CustomerMessage): Customer

}