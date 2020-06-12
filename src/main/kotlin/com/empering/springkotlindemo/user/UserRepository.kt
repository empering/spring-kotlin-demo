package com.empering.springkotlindemo.user

import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
    fun findByName(name: String): MutableList<User>
}