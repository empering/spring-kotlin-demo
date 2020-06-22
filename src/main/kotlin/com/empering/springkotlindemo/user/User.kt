package com.empering.springkotlindemo.user

import com.empering.springkotlindemo.travelFunds.TravelFundsRequest
import java.util.*
import javax.persistence.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var name: String = ""
    var email: String = ""
    var position: String = ""

    @OneToMany(mappedBy = "user")
    var travelFundsRequests: MutableSet<TravelFundsRequest> = HashSet()

    fun getTravelFundsRequests(): List<TravelFundsRequest> =
            travelFundsRequests.sortedWith(compareBy { it.startDate })

    fun getTravelFundsRequest(id: Long): TravelFundsRequest? {
        for (travelFundsRequest in travelFundsRequests) {
            if (travelFundsRequest.id == id) {
                return travelFundsRequest
            }
        }

        return null
    }
}