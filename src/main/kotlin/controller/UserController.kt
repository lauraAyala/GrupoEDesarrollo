package controller

import model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import service.UserService

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin
@RestController
@RequestMapping("/user")
    class UserController(val userService: UserService) {

        @PostMapping("/registerUser")
        fun createdUser(@RequestBody user: User) : ResponseEntity<User> {

            val user = userService.createUser(user)

            return  ResponseEntity(user, HttpStatus.CREATED)

        }

    }