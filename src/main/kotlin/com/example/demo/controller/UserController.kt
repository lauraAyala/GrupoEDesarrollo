package com.example.demo.controller


import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.example.demo.service.UserService

@RestController
class UserController {

   /* @Autowired
    lateinit var repo : UserRepository*/

    @Autowired
    lateinit var service : UserService

    @GetMapping("/")
    fun holaMundo(): String{
        return "Hola Mundo"
    }

    @GetMapping("/users")
    fun getUsers() : List<User>{
        return service.allUsers()
    }

    @PostMapping("/register")
    fun saveUser(@RequestBody user : User) : ResponseEntity<User> {
        service.createUser(user)
        return ResponseEntity(user, HttpStatus.CREATED)
    }

}