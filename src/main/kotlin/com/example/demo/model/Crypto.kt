package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
open
class Crypto() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null
    @Column
    var name: String? =null
    @Column
    var date: LocalDateTime?= null
    @Column
    var quote: Double?= null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = " id user")
    var user : User? = null

    constructor(nameC: String, dateC: LocalDateTime, cryptoQ:Double) : this()  {

        this.name = nameC
        this.date = dateC
        this.quote = cryptoQ
    }
    fun cryptoWithQuote(quote:Double){

        this.quote = quote
    }

    fun updateQuote() : Crypto{

        this.quote= this.quote!!+(this.quote!! * 0.05)

        return this
    }


}

