package com.hexagonal.adapters.out

import com.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.hexagonal.adapters.out.client.mapper.AddressResponseMapper
import com.hexagonal.application.core.domain.Address
import com.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    val findAddessByZipCodeClient: FindAddressByZipCodeClient,
    val addressResponseMapper: AddressResponseMapper
) : FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address {
        val addressResponse = findAddessByZipCodeClient.find(zipCode)
        return addressResponseMapper.toAddressResponse(addressResponse)
    }
}