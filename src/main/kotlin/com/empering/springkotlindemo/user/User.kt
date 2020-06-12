package com.empering.springkotlindemo.user

import com.empering.springkotlindemo.travelFunds.TravelFundsRequest
import java.util.HashSet
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        var name: String,
        var email: String,
        var position: String,
        @OneToMany(mappedBy = "user")
        var travelFundsRequests: MutableSet<TravelFundsRequest> = HashSet()
)