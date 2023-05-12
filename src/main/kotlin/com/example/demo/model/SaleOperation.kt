package com.example.demo.model

class SaleOperation() : OperationType() {

    override fun realizeAction(operation: Operation) {

            if (operation.userInterested != null) {
                operation.userCreated!!.confirmationTransfer()
            }

    }
}