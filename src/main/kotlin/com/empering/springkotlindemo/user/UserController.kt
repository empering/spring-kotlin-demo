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

    @ResponseBody
    @GetMapping("/all")
    fun getUserAll(): MutableIterable<User> {
        val allUsers = userService.getAllUsers()

        allUsers.forEach { user: User ->
            this.printUser(user)
        }

        return allUsers
    }

    @ResponseBody
    @GetMapping("{id}")
    fun getUser(@PathVariable id: Long): User {
        val user = userService.getUser(id).get();

        this.printUser(user)

        return user
    }

    @ResponseBody
    @GetMapping("/search/{name}")
    fun getUserByName(@PathVariable name: String): MutableIterable<User> {
        println("SEARCH_NAME IS $name")

        val users = userService.getUser(name);

        users.forEach { user: User ->
            this.printUser(user)
        }

        return users
    }

    private fun printUser(user: User) {
        println("${user.id} : ${user.name} (${user.email} / ${user.position})")
    }
}
