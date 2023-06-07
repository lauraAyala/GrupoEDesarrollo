package com.example.demo.service

import com.example.demo.model.Crypto
import com.example.demo.repositories.CryptoRepository
import dto.CryptoDTO
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

    fun allCryptos(): List<CryptoDTO>{
        var cryptos = repo.findAll()
        var cryptosDto : ArrayList<CryptoDTO> = ArrayList()
        while (cryptos.size != 0){
            var crypto = cryptos.get(0)
            var cryptoDTO = CryptoDTO(crypto.name!!, crypto.quote!!)
            cryptosDto.add(cryptoDTO)
            cryptos.removeAt(0)

        }

        return cryptosDto
    }
}