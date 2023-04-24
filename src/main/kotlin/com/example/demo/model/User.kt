package com.example.demo.model

import jakarta.persistence.*
import org.hibernate.collection.spi.PersistentBag
import org.hibernate.collection.spi.PersistentCollection
import java.util.Observable
import java.util.Observer


@Entity
@Table(name = "userT")
open class User()  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
    @Column
    var name : String? = null
    @Column
    var lastName : String? = null
    @Column
    var email : String? = null
    @Column
    var password : String? = null
    @Column
    var direction : String? = null
    @Column
    var cvuMP : String?=null
    @OneToMany( fetch = FetchType.EAGER , mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    var cryptos: ArrayList<Crypto> = ArrayList<Crypto>()
        //var cryptos: PersistentBag<Crypto>? = null



    constructor(nameU: String, lastNameU: String, emailU: String, passwordU: String, directionU: String, cvu: String):this(){
        this.name = nameU
        this.lastName = lastNameU
        this.email = emailU
        this.password = passwordU
        this.direction = directionU
        this.cvuMP = cvu
    }

    fun addCryptoActivity(cryptoA: Crypto) {

        this.cryptos.add(cryptoA)

    }



}
