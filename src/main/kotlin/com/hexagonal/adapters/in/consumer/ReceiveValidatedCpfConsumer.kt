package com.hexagonal.adapters.`in`.consumer

import com.hexagonal.adapters.`in`.consumer.mapper.CustomerMessageMapper
import com.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCpfConsumer(
    val updateCustomerInputPort: UpdateCustomerInputPort,
    val customerMessageMapper: CustomerMessageMapper
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "hexagon")
    fun receive(customerMessage: CustomerMessage) {
        val customer = customerMessageMapper.toCustomer(customerMessage)
        updateCustomerInputPort.update(customer, customerMessage.zipCode)
    }

}