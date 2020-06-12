package com.empering.springkotlindemo.travelFunds

import com.empering.springkotlindemo.user.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class TravelFundsService(
        var travelFundsRepository: TravelFundsRepository
) {
    fun putRequest(travelFundsRequest: TravelFundsRequest) {
        travelFundsRepository.save(travelFundsRequest)
    }

    fun getRequest(id: Long): Optional<TravelFundsRequest> {
        return travelFundsRepository.findById(id)
    }

    fun getRequestByUser(user: User): MutableList<TravelFundsRequest> {
        return travelFundsRepository.findByUser(user)
    }
}