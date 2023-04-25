package com.example.demo.model

import jakarta.persistence.*

@Entity
open
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
    fun cryptoWithQuote(quote:Int){

        this.cryptoQuote = quote
    }


}