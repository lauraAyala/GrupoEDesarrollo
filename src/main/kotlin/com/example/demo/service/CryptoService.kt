package com.example.demo.service

import com.example.demo.model.Crypto
import com.example.demo.repositories.CryptoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CryptoService {

    @Autowired
    lateinit var repo : CryptoRepository

    fun saveCrypto(crypto : Crypto) : Crypto {
        repo.save(crypto)
        return crypto
    }

    fun allCryptos(): List<Crypto>{
        return repo.findAll()
    }
}