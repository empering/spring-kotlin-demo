package com.empering.springkotlindemo.travelFunds

import com.empering.springkotlindemo.user.User
import com.empering.springkotlindemo.user.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.text.SimpleDateFormat
import java.util.*

const val TEST_USER_ID: Long = 1
const val TEST_REQUST_ID: Long = 1
const val TEST_REQUEST_URL: String = "/travel-funds/{userId}"

val df = SimpleDateFormat("yyyy-MM-dd")

@ExtendWith(SpringExtension::class)
@WebMvcTest(TravelFundsController::class)
class TravelFundsControllerTest(
        @Autowired val mockMvc: MockMvc
) {

    @MockBean
    lateinit var travelFundsRepository: TravelFundsRepository

    @MockBean
    lateinit var userRepository: UserRepository

    @BeforeEach
    fun init() {
        val user = User()
        val request1 = TravelFundsRequest()
        val request2 = TravelFundsRequest()

        user.name = "테스터"
        user.email = "test@ibdata.co.kr"
        user.position = "A"

        request1.travelBusiness = "테스트"
        request1.travelArea = "경기도 고양시 일산"
        request1.travelOrgan = "한국건설기술연구원"
        request1.nights = 5
        request1.days = 6
        request1.amount = 100000
        request1.startDate = df.parse("2020-01-05")
        request1.endDate = df.parse("2020-01-11")

        request2.travelBusiness = "테스트"
        request2.travelArea = "경기도 고양시 일산"
        request2.travelOrgan = "한국건설기술연구원"
        request2.nights = 10
        request2.days = 11
        request2.amount = 200000
        request2.startDate = df.parse("2020-01-12")
        request2.endDate = df.parse("2020-01-31")

        val requestList: MutableIterable<TravelFundsRequest> = mutableListOf(request1, request2)

        given(this.userRepository.findById(TEST_USER_ID)).willReturn(Optional.ofNullable(user))
        given(this.travelFundsRepository.findAll()).willReturn(requestList)
        given(this.travelFundsRepository.findById(TEST_USER_ID)).willReturn(Optional.of(request1))
    }

    @Test
    internal fun testPostRequest() {
        mockMvc.perform(post(TEST_REQUEST_URL, TEST_USER_ID)
                .param("travelBusiniss", "테스트")
                .param("travelArea", "경기도 고양시 일산")
                .param("travelOrgan", "한국건설기술연구원")
                .param("nights", "5")
                .param("days", "6")
                .param("amount", "100000")
                .param("startDate", "2020-01-05")
                .param("endDate", "2020-01-11")
        ).andExpect(status().is2xxSuccessful)

        Mockito.verify(userRepository).findById(TEST_USER_ID)
    }

    @Test
    internal fun testGetRequestAll() {
        mockMvc.perform(get("$TEST_REQUEST_URL/all", TEST_USER_ID))
                .andExpect(status().is2xxSuccessful)
    }

    @Test
    internal fun testGetRequest() {
        mockMvc.perform(get("$TEST_REQUEST_URL/{id}", TEST_USER_ID, TEST_REQUST_ID))
                .andExpect(status().is2xxSuccessful)
    }
}