package com.empering.springkotlindemo.travelFunds

import com.empering.springkotlindemo.user.User
import org.springframework.data.repository.CrudRepository

interface TravelFundsRepository: CrudRepository<TravelFundsRequest, Long> {
    fun findByUser(user: User): MutableList<TravelFundsRequest>
}