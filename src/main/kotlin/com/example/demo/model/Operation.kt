package com.example.demo.model

import jakarta.persistence.*
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.jvm.Transient

open class Operation (){


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
    @OneToOne(fetch = FetchType.EAGER)
    var cryptoActive : Crypto? = null
    @Column
    var cantidadNominal : Int? = null
    @Column
    var quoteCrypto : Int? = null
    @Column
    var amountOperation : Int? = null
    var userCreated : User? = null
    var userInterested : User? = null
    var operationType : OperationType? = null
    @Column
    var date : LocalDateTime? = null

    constructor(cryptoActiveOperation : Crypto, cantidadNominal : Int, userOperation : User, operationType : OperationType) : this() {
        this.cryptoActive =  cryptoActiveOperation
        this.cantidadNominal = cantidadNominal
        this.userCreated = userOperation
        this.operationType = operationType
        this.date= LocalDateTime.now()
    }

    fun updaeCrypto(cryptoAct: Crypto): Operation {

        this.cryptoActive= cryptoAct
        return (this)

    }

    fun cancelateOperation() {
        TODO("Not yet implemented")

        this.operationType= CaceledOperation()
        this.operationType!!.realizeAction(this)
    }

    fun updateUserInterested(user: User) : Operation{

        this.userInterested= user
        this.takeAction()

        return this

    }

    fun takeAction() {

        if (this.userInterested != null){
            //this.operationType!!.realizeAction(this.userCreated,this.userInterested)
            this.operationType!!.realizeAction(this)
            this.userCreated!!.state="realized"
        }
       this.userCreated!!.state="waiting"


    }


}