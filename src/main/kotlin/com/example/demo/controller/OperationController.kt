package com.example.demo.controller

import com.example.demo.model.Crypto
import com.example.demo.model.Operation
import com.example.demo.service.CryptoService
import com.example.demo.service.OperationService
import dto.CryptoDTO
import dto.OperationDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OperationController {

    @Autowired
    lateinit var service : OperationService

    @GetMapping("/operations")
    fun allOperations() : List<OperationDTO>{
        return service.allOperations()
    }

    @PostMapping("/addOperation")
    fun saveCrypto(@RequestBody oper : Operation) : ResponseEntity<Operation> {
        service.saveOperation(oper)
        return ResponseEntity(oper, HttpStatus.CREATED)
    }
}