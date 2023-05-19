package com.example.demo.model

class BuyOperation() : OperationType() {

     override fun realizeAction(operation: Operation) : Operation{

         var user = operation.userCreated!!.sendTransfer(operation.userInterested,operation.date!!)

         return (operation.updateUserInterested(user))
        //operation.userCreated!!.arrivedReception(operation.userInterested)
    }
}