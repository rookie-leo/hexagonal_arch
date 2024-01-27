package com.hexagonal.application.core.domain

data class Customer(
    val id: String,
    val name: String,
    var address: Address,
    val cpf: String,
    val isValidCpf: Boolean,
)