package com.empering.springkotlindemo.travelFunds

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest(TravelFundsController::class)
class TravelFundsControllerTest (
        @Autowired var mockMvc: MockMvc
) {
    @MockBean
    lateinit var travelFundsRepository: TravelFundsRepository

    @Test
    fun test() {

    }

    @Test
    fun testPostMethod() {
        mockMvc.perform(post("/travel-funds")
                .param("travelBusiniss", "테스트")
                .param("travelArea", "경기도 고양시 일산")
                .param("travelOrgan", "한국건설기술연구원")
                .param("nights", "5")
                .param("days", "6")
                .param("amount", "100000")
                .param("user", "1")
                .param("startDate", "2020-01-05")
                .param("endDate", "2020-01-11")
        ).andExpect(status().is2xxSuccessful)
    }

}