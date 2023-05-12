package com.example.demo.model

import java.time.LocalDateTime

class CryptoBuilder : Crypto() {

    fun cryptoWithName(nameC: String){

        this.name = nameC
    }

    fun cryptoWithDate(dateC: LocalDateTime){

        this.date = dateC
    }

    fun build() : CryptoBuilder {
        //"ALICEUSDT", LocalDateTime.of(2023, 4, 18, 3, 46).toString(),0
        return CryptoBuilder()

    }
}