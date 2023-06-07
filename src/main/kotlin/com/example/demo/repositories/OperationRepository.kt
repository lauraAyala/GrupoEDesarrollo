package com.example.demo.repositories

import com.example.demo.model.Crypto
import com.example.demo.model.Operation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OperationRepository : JpaRepository<Operation, Long> {
}