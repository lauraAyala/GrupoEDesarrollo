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

    fun saleCrypto( cryptoA: Crypto): Operation{

       // var cryptoA=  Crypto("ALICEUSDT", LocalDateTime.now(),200.0)
        var cryptoA = cryptoA.updateQuote()
        var saleOperation = SaleOperation()
        var operation = Operation(cryptoA,2,this,saleOperation)
        this.operations.add(operation)
        //this.takeAction(operation)
        this.cantOperations+=1

        return this.takeAction(operation)
    }

    private fun takeAction(operation: Operation) : Operation {

        return operation.takeAction()

    }

    fun buyCrypto(operation: Operation) : Operation{

        //var cryptoA:Crypto =  Crypto("MATICUSDT", LocalDateTime.now(),200.0)
        //cryptoA = cryptoA.updateQuote()
        var cryptoA: Crypto? = operation.cryptoActive
        cryptoA = cryptoA!!.updateQuote()
        var buyOperation = BuyOperation()
        var operationA= Operation(cryptoA!!,operation.cantidadNominal!!,this,buyOperation)
        operationA = operationA.updateUserInterested(operation.userCreated!!)
        this.cantOperations+=1
        this.operations.add(operationA)


        return operationA.takeAction()
    }


    fun arrivedReception(user: User?): Boolean {

        return this.reception

    }

    fun sendTransfer(sallerUser: User?,date: LocalDateTime) : User{

        var user : User? = null
        var dateActuality : LocalDateTime = LocalDateTime.now()
           if (date.dayOfYear == dateActuality.dayOfYear && date.hour == dateActuality.hour && date.minute < dateActuality.minute){

              user = sallerUser!!.sumPoint(10)
           }
           else{

               user = sallerUser!!.sumPoint(5)

           }
            sallerUser!!.updateReception()

        return  user


    }

    fun updateReception() : User {

        this.reception=true
        return this

    }

    fun confirmationTransfer()  {

        this.updateReception()
    }

    fun canceledOperation(operation: Operation): Operation{

        this.operations.remove(operation)
        var cancelated = CaceledOperation()
        operation.userCreated= this
        operation.operationType= cancelated
        operation.takeAction()
        return operation

    }

    fun subtractCantOperation() : User {

        if (this.cantOperations != 0) {

            this.cantOperations -= 1
        }

        return this
    }

    fun subtractPoint() : User{

        if (this.point != 0) {
            this.point = this.point - 20
        }
        return this
    }

    fun sumPoint(cant: Int): User {

        this.point = cant

        return this
    }


}
