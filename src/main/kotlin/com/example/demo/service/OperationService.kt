package com.example.demo.service

import com.example.demo.model.Operation
import com.example.demo.repositories.OperationRepository
import dto.OperationDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OperationService {

    @Autowired
    lateinit var repo : OperationRepository

    fun saveOperation(oper : Operation) : Operation{
        repo.save(oper)
        return oper
    }



    fun allOperations(): List<OperationDTO>{
        var operations = repo.findAll()
        var operationsDto : ArrayList<OperationDTO> = ArrayList()
        while (operations.size != 0){
            var oper = operations.get(0)
            var operationDTO = OperationDTO(oper.operationType!!.name!!, oper.userCreated!!.name!!)
            operationsDto.add(operationDTO)
            operations.removeAt(0)

        }

        return operationsDto
    }

    fun operationWithUser(name: String?, cryptoName: String): Operation {

        var operations = repo.findAll()
        var cant= 0
        var operation = operations.get(cant)
        while (cant != operations.size || (operation.userCreated!!.name == name )&& operation.cryptoActive!!.name == cryptoName) {

            cant += 1
            operation = operations.get(cant)
        }
        return operation
    }
}