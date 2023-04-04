package model

import java.time.LocalDate
import java.util.*

class Aplication() : Observer {


    var listUsers: ArrayList<User> = ArrayList()

    var listCryptos: ArrayList<Crypto> = ArrayList()
    var date: LocalDate? = null
    var operationsOfSaleCryptos: ArrayList<User> = ArrayList()
    var operationsOfBuyCryptos: ArrayList<User> = ArrayList()

    fun userRegister(user: User) {

        user.addObserver(this)
        this.listUsers.add(user)

    }

    fun registerCripto(cryptoA: Crypto) {

        this.listCryptos.add(cryptoA)
    }

    override fun update(user: Observable?, p1: Any?) {

        if ( this.isOperationSale(p1)){

            this.operationsOfSaleCryptos.add(user as User)
        }
        else{

            this.operationsOfBuyCryptos.add(user as User)
        }

    }

    private fun isOperationSale(operation: Any?): Boolean {

        // se va a modificar
        return (true)

    }

}
