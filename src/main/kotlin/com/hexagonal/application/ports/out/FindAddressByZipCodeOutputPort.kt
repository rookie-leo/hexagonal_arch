package com.hexagonal.application.ports.out

import com.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address

}