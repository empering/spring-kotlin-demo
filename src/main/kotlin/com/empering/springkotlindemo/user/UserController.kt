package com.empering.springkotlindemo.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
        var userService: UserService
) {
    @PutMapping()
    fun putUser(user: User) {
        println(user.toString())
        userService.putUser(user)
    }

    @GetMapping("/all")
    fun getUserAll() {
        userService.getAllUsers().forEach { user: User? ->
            println(user.toString())
        }
    }

    @GetMapping("{id}")
    fun getUser(@PathVariable id: Long) {
        println(userService.getUser(id))
    }

    @GetMapping("/search/{name}")
    fun getUserByName(@PathVariable name: String) {
        userService.getUser(name).forEach { user: User ->
            println(user.toString())
        }
    }
}
