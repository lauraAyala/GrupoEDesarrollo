package com.example.demo.model

class SaleOperation() : OperationType() {

    override fun realizeAction(operation: Operation) : Operation{

            if (operation.userInterested != null) {
                operation.userCreated!!.confirmationTransfer()

                return operation
            }

        return operation

    }
}