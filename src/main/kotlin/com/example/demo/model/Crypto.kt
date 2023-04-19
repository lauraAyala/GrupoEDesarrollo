package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
//@Table(name = "cryptoCrud")
class Crypto() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null
    @Column
    var name: String? =null
    @Column
    var date: String?= null
    @Column
    var cryptoQuote: Int?= null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id user")
    var user : User? = null

    var amountOfTheCrypto: Int?= null
    var amountOfTheOperation: Int?= null

    constructor(nameC: String, dateC: String, cryptoQ:Int) : this()  {

        this.name = nameC
        this.date = dateC
        this.cryptoQuote = cryptoQ
    }
    fun cryptoWithName(nameC: String){

        this.name = nameC
    }

    fun cryptoWithDate(dateC: String){

        this.date = dateC
    }

    fun cryptoWithQuote(quote:Int){

        this.cryptoQuote = quote
    }

    fun build() : Crypto {
          return Crypto("ALICEUSDT", LocalDateTime.of(2023, 4, 18, 3, 46).toString(),0)

    }

}