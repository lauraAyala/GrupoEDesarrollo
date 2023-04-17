package model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.springframework.data.annotation.Id
import java.util.*

@Entity
class User (): Observable() {

    @Id
    var id : Int? = null
    @Column(unique=true, length = 8)
    var name: String? = null
    @Column(name="lastName", length = 8)
    var lastName: String? = null
    @Column(name="email", length = 8)
    var email: String? = null
    @Column(name="password", length = 8)
    var password: String? = null
    @Column(name="direction", length = 8)
    var direction: String? = null
    @Column(name="cvuMP", length = 8)
    var cvuMP: String? = null
    @Column(name="cryptos", length = 8)
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

    fun createOperacion (crypto: Crypto, typeOperation : String){
        var operationNew : Operation = Operation(crypto, 2 , this, typeOperation)
    }




}