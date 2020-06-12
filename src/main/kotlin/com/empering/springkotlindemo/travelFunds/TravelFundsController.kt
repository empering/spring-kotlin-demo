package com.empering.springkotlindemo.travelFunds

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/travel-funds")
class TravelFundsController(
        var travelFundsRepository: TravelFundsRepository
) {

    @PostMapping()
    fun putRequest(@Validated travelFundsRequest: TravelFundsRequest) {
        travelFundsRequest.toString()
        travelFundsRepository.save(travelFundsRequest)
    }

    @GetMapping("/all")
    fun getRequest() {
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