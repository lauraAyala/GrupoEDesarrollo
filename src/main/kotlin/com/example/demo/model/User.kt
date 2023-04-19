package com.example.demo.model

import jakarta.persistence.*
import org.hibernate.collection.spi.PersistentBag


@Entity
@Table(name = "userCrudTestD")
class User() {

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
    var cryptos: PersistentBag<Crypto>? = null



    constructor(nameU: String, lastNameU: String, emailU: String, passwordU: String, directionU: String, cvu: String):this(){
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


}
