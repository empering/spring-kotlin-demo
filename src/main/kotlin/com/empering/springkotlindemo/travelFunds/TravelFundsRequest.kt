package com.empering.springkotlindemo.travelFunds

import com.empering.springkotlindemo.user.User
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*

@Entity
class TravelFundsRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var travelBusiness: String? = ""
    var travelArea: String? = ""
    var travelOrgan: String? = ""

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var startDate: Date? = null

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var endDate: Date? = null
    var days: Int? = 0
    var nights: Int? = 0
    var amount: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "user_id")
    var user: User? = null
}