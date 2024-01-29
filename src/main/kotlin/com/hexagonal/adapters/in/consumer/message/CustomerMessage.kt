package com.hexagonal.adapters.`in`.consumer.message

data class CustomerMessage(
    var id: String,
    val name: String,
    var zipCode: String,
    val cpf: String,
    val isValidCpf: Boolean
)