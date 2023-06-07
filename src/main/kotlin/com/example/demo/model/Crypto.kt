package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime
import kotlin.jvm.Transient

@Entity
@Table(name="crypto")
open
class Crypto() : Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null
    @Column
    var name: String? =null
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-ddTHH:mm:ss")
    var date: LocalDateTime?= null
    @Column
    var quote: Double?= null
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = " id user")
    //var users: ArrayList<User> = ArrayList()
    @Transient
    var user : User? = null

    constructor(nameC: String, dateC: LocalDateTime, cryptoQ:Double) : this()  {

        this.name = nameC
        this.date = dateC
        this.quote = cryptoQ
    }
    constructor(nameC: String, cryptoQ:Double, user :User) : this()  {

        this.name = nameC
        this.date = LocalDateTime.now()
        this.quote = cryptoQ
        this.user=user
        //this.users.add(user)
    }
    fun cryptoWithQuote(quote:Double){

        this.quote = quote
    }

    fun updateQuote() : Crypto{

        this.quote= this.quote!!+(this.quote!! * 0.05)

        return this
    }


}

