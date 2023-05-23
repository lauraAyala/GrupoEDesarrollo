package com.example.demo.service

import com.example.demo.model.Crypto
import com.example.demo.model.Operation
import com.example.demo.repositories.UserRepository
import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService {

    @Autowired
    lateinit var repo : UserRepository

    fun createUser(user : User) : User {
        repo.save(user)
        return user
    }

    fun allUsers(): List<User>{
        return repo.findAll()
    }
    fun recoverUser(id: Long): User{

        return repo.getOne(id)

    }

    fun saleACrypto(crypto: Crypto) : Operation{

        var user = crypto.user
        return user!!.saleCrypto(crypto)

    }


}