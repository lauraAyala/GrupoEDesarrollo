package com.example.demo.model

class OperationBuilder : Operation() {

    fun operationWithUser(userO: User){
        this.userCreated = userO
    }

    fun operationWithCantidadNominal(cantidad : Int){
        this.cantidadNominal = cantidad
    }
    fun operationWithCrypto(cryptoO: Crypto){
        this.cryptoActive = cryptoO
    }

    fun operationWithType(operationO : OperationType){
        this.operationType = operationO
    }

    fun builder(): OperationBuilder {
        //CryptoBuilder().build(),2,UserBuilder().builder(),"Compra"
        return OperationBuilder()
    }

}