package com.example.demo.model

class UserBuilder : User() {

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

    fun builder(): UserBuilder{
//"Laura","Ayala","lau@gmail","123","chile","123456"
        return UserBuilder()
    }
}