package com.hexagonal.adapters.out.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
data class CustomerEntity(

    @Id
    var id: String,

    var name: String,

    var email: String,

    var address: AddressEntity
)