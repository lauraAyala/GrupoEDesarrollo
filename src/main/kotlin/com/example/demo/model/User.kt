package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime
import kotlin.jvm.Transient

@Entity
@Table(name = "user_table")
open class User() {



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
    @Transient
    @OneToMany
    var cryptos: ArrayList<Crypto> = ArrayList<Crypto>()
    @Column
    var cantOperations: Int = 0
        //var cryptos: PersistentBag<Crypto>? = null
   @Column
    var point : Int =0
    @Transient
    var reception : Boolean = false
    //@OneToMany( fetch = FetchType.EAGER , mappedBy = "userCreated", cascade = arrayOf(CascadeType.ALL))
    @Transient
    @OneToMany
    var operations: ArrayList<Operation> = ArrayList()

    var state: String? = null



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

    fun saleCrypto(): Operation{

        var cryptoA=  Crypto("ALICEUSDT", LocalDateTime.now(),200.0)
        cryptoA = cryptoA.updateQuote()
        var saleOperation = SaleOperation()
        var operation = Operation(cryptoA,2,this,saleOperation)
        this.operations.add(operation)
        this.takeAction(operation)
        this.cantOperations+=1

        return operation
    }

    private fun takeAction(operation: Operation) {

        operation.takeAction()

    }

    fun buyCrypto(operation: Operation) : Operation{

        //var cryptoA:Crypto =  Crypto("MATICUSDT", LocalDateTime.now(),200.0)
        //cryptoA = cryptoA.updateQuote()
        var cryptoA: Crypto? = operation.cryptoActive
        cryptoA = cryptoA!!.updateQuote()
        var buyOperation = BuyOperation()
        var operationA= Operation(cryptoA!!,operation.cantidadNominal!!,this,buyOperation)
        operationA.userInterested= operation.userCreated
        this.cantOperations+=1
        this.operations.add(operationA)

        return operationA
    }


    fun arrivedReception(user: User?): Boolean {

        return this.reception

    }

    fun sendTransfer(sallerUser: User?) {

            sallerUser!!.updateReception()


    }

    private fun updateReception() {

        this.reception=true

    }

    fun confirmationTransfer() {

        this.updateReception()
    }

    fun canceledOperation(operation: Operation): User {

        this.cantOperations-=1
        if (this.point != 0) {
            this.point -= 20
        }
        this.operations.remove(operation)

        return this

    }


}
