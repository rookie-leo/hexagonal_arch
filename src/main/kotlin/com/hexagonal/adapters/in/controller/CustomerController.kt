package com.hexagonal.adapters.`in`.controller

import com.hexagonal.adapters.`in`.controller.mapper.CustomerMapper
import com.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    val insertCustomerInputPort: InsertCustomerInputPort,
    val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    val updateCustomerInputPort: UpdateCustomerInputPort,
    val deleteCustomerByIdInputPort: DeleteCustomerByIdInputPort,
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

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    fun update(@PathVariable("id") id: String, @Valid @RequestBody customerRequest: CustomerRequest) {
        val customer = customerMapper.toCustomer(customerRequest)
        customer.id = id
        updateCustomerInputPort.update(customer, customerRequest.zipCode)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: String) {
        deleteCustomerByIdInputPort.delete(id)
    }
}