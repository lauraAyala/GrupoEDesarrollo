package com.example.demo.model

class CaceledOperation() : OperationType() {
    override fun realizeAction(operation: Operation): Operation {

        if (operation.userCreated != null) {
           var user = operation.userCreated!!.subtractCantOperation()
            operation.userCreated= user

             return operation.subtractPointAndRemoveOperation()

        }
        return operation
    }


}

