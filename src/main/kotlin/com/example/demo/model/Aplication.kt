package com.example.demo.model

import java.time.LocalDateTime
import kotlin.collections.ArrayList


class Aplication {

   // @OneToMany( fetch = FetchType.EAGER , mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    var cryptos: ArrayList<Crypto> = ArrayList<Crypto>()
   // @OneToMany( fetch = FetchType.EAGER , mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    var users: ArrayList<User> = ArrayList<User>()
    var operations: ArrayList<Operation> = ArrayList()

    fun registerUser(user: User){

        this.users.add(user)
    }

    fun addCrypto(crypto: Crypto){

        this.cryptos.add(crypto)

    }

    fun registerOperation(operation: Operation) : Aplication {



        var cryptoAct = this.quoteActive(operation.cryptoActive)
        var operationAct = operation.updaeCrypto(cryptoAct)
        this.operations.add(operation)
        this.addCrypto(cryptoAct)
        //this.takeAction(operationAct)

       /* if (this.isPosibleAction(cryptoAct, operation.amountOperation)){

            this.takeAction(operationAct)
        }
        else {

            operation.cancelateOperation()

        }*/

        return this

    }

    private fun isPosibleAction(cryptoAct: Crypto, amountOperation: Int?): Boolean {

            return (amountOperation!! < (cryptoAct.quote!!) || amountOperation > (cryptoAct.quote!!))


    }
/*
private fun takeAction(operationAct: Operation) : String{



      if (operationAct.operationType == "sale"){

          return this.arrivedTranfer(operationAct)
      }
      return (this.confirmationReception(operationAct))

  }

  private fun confirmationReception(operationAct: Operation) :String{

      if (operationAct.userCreated!!.arrivedReception()){

          return "confirmation of reception"

      }

      return "waiting reception"


  }*/

  private fun searchUer(crypto: Crypto): User?{

          for ( u in this.users){

              if (u.cryptos.contains(crypto)){

                  return u

              }

          }

      return null
  }

  private fun arrivedTranfer(operationAct: Operation) : String {

      operationAct.userInterested?.sendTransfer(operationAct.userCreated)
      return ("transfer realized")


  }

  fun quoteActive(crypto: Crypto?) : Crypto{

      if (crypto!!.date == LocalDateTime.now()){

          crypto.updateQuote()
      }

      return crypto

  }



}