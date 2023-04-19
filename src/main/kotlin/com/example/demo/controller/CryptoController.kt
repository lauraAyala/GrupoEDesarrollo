package com.example.demo.controller


import com.example.demo.model.Crypto
import com.example.demo.service.CryptoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CryptoController {

    @Autowired
    lateinit var service : CryptoService

    @GetMapping("/cryptos")
    fun allCryptos() : List<Crypto>{
        return service.allCryptos()
    }

    @PostMapping("/addCrypto")
    fun saveCrypto(@RequestBody crypto : Crypto) : ResponseEntity<Crypto> {
        service.saveCrypto(crypto)
        return ResponseEntity(crypto, HttpStatus.CREATED)
    }

}