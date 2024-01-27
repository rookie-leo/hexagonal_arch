package com.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val cpf: String,

    @field:NotBlank
    val zipCode: String
)