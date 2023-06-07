package com.example.demo.model

import jakarta.persistence.*
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.jvm.Transient

@Entity
@Table(name="operation")
open class Operation (){


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null

    @Transient
    var cryptoActive : Crypto? = null
    @Column
    var cantidadNominal : Int? = null
    @Column
    var quoteCrypto : Int? = null
    @Transient
    var amountOperation : Int? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userCreate_id")
    var userCreated : User? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userInterested_id")
    var userInterested : User? = null
    @Transient
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

        var user2 = user.updateReception()
        this.userInterested= user2



        return   this

    }

    fun takeAction() : Operation{

        if (this.userInterested != null){
            //this.operationType!!.realizeAction(this.userCreated,this.userInterested)
            var oper = this.operationType!!.realizeAction(this)
            this.userCreated!!.state="realized"

            return oper
        }
       this.userCreated!!.state="waiting"
      return this

    }


    fun subtractPointAndRemoveOperation() : Operation{

        this.userCreated!!.subtractPoint()
        return this

    }


}