package com.example.demo.controller


import com.example.demo.model.Crypto
import com.example.demo.model.Operation
import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.example.demo.service.UserService
import dto.UserDTO
import jakarta.validation.Valid
import request.OperationRequest

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
        var user1= service.createUser(user)
        //var userDTO = UserDTO(user1.name!!,user1.point)
        return ResponseEntity(user, HttpStatus.CREATED)
    }
    @PostMapping("/saleCrypto")
    fun saleCrypto(@Valid @RequestBody oper:OperationRequest ) : ResponseEntity<UserDTO> {

        var user = service.recoverUser(oper.user)
        var crypto = Crypto(oper.cryptoName,oper.quote,user)
        var operation = service.saleACrypto(crypto)
        var userActual = operation.userCreated
        var userDTO = UserDTO(userActual!!.name!!, userActual.point )
        return ResponseEntity(userDTO, HttpStatus.CREATED)
    }
    @PostMapping("/buyCrypto")
    fun buyCrypto(@Valid @RequestBody oper:OperationRequest ) : ResponseEntity<UserDTO> {

        var user = service.recoverUser(oper.user)
        var userInterested = service.recoverUser(oper.userInterested)
        var crypto = Crypto(oper.cryptoName,oper.quote,user)
        var operation = service.saleACrypto(crypto)
        operation = operation.updateUserInterested(userInterested)
        var operationBuy = userInterested.buyCrypto(operation)
        var userActual = operationBuy.userCreated
        var userDTO = UserDTO(userActual!!.name!!, userActual.point )
        return ResponseEntity(userDTO, HttpStatus.CREATED)
    }

}