package com.example.demo.service

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


}