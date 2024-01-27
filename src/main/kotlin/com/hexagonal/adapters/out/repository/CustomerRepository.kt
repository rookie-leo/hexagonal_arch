package com.hexagonal.adapters.out.repository

import com.hexagonal.adapters.out.repository.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<CustomerEntity, String> {
}