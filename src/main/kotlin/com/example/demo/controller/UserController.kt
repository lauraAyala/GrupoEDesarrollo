package com.example.demo.controller


import com.example.demo.model.Crypto
import com.example.demo.model.Operation
import com.example.demo.model.User
import com.example.demo.service.CryptoService
import com.example.demo.service.OperationService
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
import request.UserRequest

@RestController
class UserController {

    @Autowired
    lateinit var service : UserService
    @Autowired
    lateinit var serviceCrypto : CryptoService
    @Autowired
    lateinit var serviceOperation : OperationService

    @GetMapping("/")
    fun holaMundo(): String{
        return "Hola Mundo"
    }

    @GetMapping("/users")
    fun getUsers() : List<User>{
        return service.allUsers()
    }

    @PostMapping("/register")
    fun saveUser(@RequestBody userRequest : UserRequest) : ResponseEntity<UserDTO> {
       var user = User(userRequest.name!!,userRequest.lastName!!,userRequest.email!!,userRequest.password!!,userRequest.direction!!,userRequest.cvuMP!!)
       service.createUser(user)
        var userDTO = UserDTO(user.name!!,user.point)
        return ResponseEntity(userDTO, HttpStatus.CREATED)
    }
    @PostMapping("/saleCrypto")
    fun saleCrypto(@Valid @RequestBody oper:OperationRequest ) : ResponseEntity<UserDTO> {

        var user = service.recoverUser(oper.user)
        var crypto = Crypto(oper.cryptoName,oper.quote,user)
        var operation = service.saleACrypto(crypto)
        var userActual = operation.userCreated
        var userDTO = UserDTO(userActual!!.name!!, userActual.point )
        serviceCrypto.saveCrypto(operation.cryptoActive!!)
        serviceOperation.saveOperation(operation)
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
        serviceCrypto.saveCrypto(crypto)
        serviceOperation.saveOperation(operationBuy)

        return ResponseEntity(userDTO, HttpStatus.CREATED)
    }

    @PostMapping("/canceledOperation")
    fun cancalateCrypto(@Valid @RequestBody oper:OperationRequest ) : ResponseEntity<UserDTO> {

        var user = service.recoverUser(oper.user)
       var operatioACancelate = serviceOperation.operationWithUser(user.name,oper.cryptoName)
       var operationCancelated =  user.canceledOperation(operatioACancelate)
        var userActual = operationCancelated.userCreated
        var userDTO = UserDTO(userActual!!.name!!, userActual.point )

        return ResponseEntity(userDTO, HttpStatus.CREATED)
    }

}