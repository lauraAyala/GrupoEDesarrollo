package com.example.demo.repositories


import com.example.demo.model.Crypto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CryptoRepository : JpaRepository<Crypto, Long>{
}