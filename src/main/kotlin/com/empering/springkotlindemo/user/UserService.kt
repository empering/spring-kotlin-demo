package com.empering.springkotlindemo.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (
        var userRepository: UserRepository) {

    fun putUser(user: User) {
        userRepository.save(user)
    }

    fun getUser(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    fun getUser(name: String): MutableList<User> {
        return userRepository.findByName(name)
    }

    fun getAllUsers(): MutableIterable<User> {
        return userRepository.findAll()
    }
}