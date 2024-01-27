package com.hexagonal.adapters.`in`.controller.response

data class CustomerResponse(
    val name: String,
    var address: AddressResponse,
    val cpf: String,
    val isValidCpf: Boolean
)