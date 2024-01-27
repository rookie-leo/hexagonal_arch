package com.hexagonal.adapters.`in`.controller

import com.hexagonal.adapters.`in`.controller.mapper.CustomerMapper
import com.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.hexagonal.application.ports.`in`.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    val insertCustomerInputPort: InsertCustomerInputPort,
    val customerMapper: CustomerMapper
) {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        insertCustomerInputPort.insert(customerMapper.toCustomer(customerRequest), customerRequest.zipCode)
    }

}