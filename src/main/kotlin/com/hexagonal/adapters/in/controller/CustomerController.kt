package com.hexagonal.adapters.`in`.controller

import com.hexagonal.adapters.`in`.controller.mapper.CustomerMapper
import com.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.application.ports.`in`.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    val insertCustomerInputPort: InsertCustomerInputPort,
    val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    val customerMapper: CustomerMapper
) {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        insertCustomerInputPort.insert(customerMapper.toCustomer(customerRequest), customerRequest.zipCode)
    }

    @GetMapping("/{id}")
    fun findById(id: String): ResponseEntity<CustomerResponse> {
        val customer = findCustomerByIdInputPort.find(id)
        return ResponseEntity.ok(customerMapper.toCustomerResponse(customer))
    }

}