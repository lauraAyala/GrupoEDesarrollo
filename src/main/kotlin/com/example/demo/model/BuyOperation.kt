package com.example.demo.model

class BuyOperation() : OperationType() {

     override fun realizeAction(operation: Operation) {

         operation.userCreated!!.sendTransfer(operation.userInterested)
        //operation.userCreated!!.arrivedReception(operation.userInterested)
    }
}