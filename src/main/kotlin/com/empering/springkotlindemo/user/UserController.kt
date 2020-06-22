package com.empering.springkotlindemo.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
        var userService: UserService
) {
    @PutMapping
    fun putUser(user: User) {
        this.printUser(user)
        userService.putUser(user)
    }

    @GetMapping("/all")
    fun getUserAll() {
        userService.getAllUsers().forEach { user: User ->
            this.printUser(user)
        }
    }

    @GetMapping("{id}")
    fun getUser(@PathVariable id: Long) {
        this.printUser(userService.getUser(id).get())
    }

    @GetMapping("/search/{name}")
    fun getUserByName(@PathVariable name: String) {
        println("SEARCH_NAME IS $name")
        userService.getUser(name).forEach { user: User ->
            this.printUser(user)
        }
    }

    private fun printUser(user: User) {
        println("${user.id} : ${user.name} (${user.email} / ${user.position})")
    }
}
