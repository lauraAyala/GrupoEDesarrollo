package model

import java.util.*


class User (): Observable() {

        var name: String? = null
        var lastName: String? = null
        var email: String? = null
        var password: String? = null
        var direction: String? = null
        var cvuMP: String? = null
        var cryptos: ArrayList<Crypto> = ArrayList()


        constructor(nameU: String, lastNameU: String, emailU: String, passwordU: String, directionU: String, cvu: String) : this (){

            this.name = nameU
            this.lastName = lastNameU
            this.email = emailU
            this.password = passwordU
            this.direction = directionU
            this.cvuMP = cvu
        }

        fun whitName(nameU:String): User{

            this.name = nameU
            return this
        }

        fun withLastName(lastNameU: String): User{

            this.lastName = lastNameU
            return this
        }

        fun withEmail(emailU: String): User{

            this.email = emailU
            return this
        }

        fun withPassword(passwordU: String): User{

            this.password = passwordU
            return this
        }

        fun withDirection(directionU: String): User{

            this.direction = directionU
            return this
        }

        fun withCvuMP(cvu: String): User{

            this.cvuMP = cvu
            return this
        }

        fun builder(): User{

            return User("Laura","Ayala","lau@gmail","123","chile","123456")
        }

        fun addCryptoActivity(crypto:Crypto){

            this.cryptos.add(crypto)
        }

        fun saleCrypto(crypto: Crypto){

            crypto.operation = "sale"
            notifyObservers( crypto)

        }

    fun buyCrypto(crypto: Crypto){

        crypto.operation = "buy"
        notifyObservers( crypto)

    }




}