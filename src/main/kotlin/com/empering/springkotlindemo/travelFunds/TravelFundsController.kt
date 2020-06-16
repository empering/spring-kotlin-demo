package com.empering.springkotlindemo.travelFunds

import com.empering.springkotlindemo.user.User
import com.empering.springkotlindemo.user.UserRepository
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/travel-funds/{userId}")
class TravelFundsController(
        var travelFundsRepository: TravelFundsRepository,
        var userRepository: UserRepository
) {

    @ModelAttribute("user")
    fun findUser(@PathVariable userId: Long): User = userRepository.findById(userId).get()

    @PostMapping()
    fun postRequest(travelFundsRequest: TravelFundsRequest, user: User) {
        travelFundsRequest.user = user
        travelFundsRequest.toString()
        travelFundsRepository.save(travelFundsRequest)
    }

    @GetMapping("/all")
    fun getRequestAll() {
        travelFundsRepository.findAll().forEach {
            travelFundsRequest: TravelFundsRequest? ->
            println(travelFundsRequest.toString())
        }
    }

    @GetMapping("{id}")
    fun getRequest(@PathVariable id: Long) {
        println(travelFundsRepository.findById(id))
    }
}