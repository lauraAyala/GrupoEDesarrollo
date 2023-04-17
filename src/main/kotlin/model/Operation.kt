package model


class Operation (){

    var cryptoActive : Crypto? = null
    var cantidadNominal : Int? = null
    var cotizacionCrypto : Int? = null
    var montoOperacion : Int? = null
    var user : User? = null
    var operationType : String? = null

    constructor(cryptoActiveOperation : Crypto, cantidadNominal : Int, userOperation : User, operationType : String) : this() {
        this.cryptoActive =  cryptoActiveOperation
        this.cantidadNominal = cantidadNominal
        this.user = userOperation
        this.operationType = operationType
    }

     fun operationWithUser(userO: User){
         this.user = userO
     }

    fun operationWithCantidadNominal(cantidad : Int){
        this.cantidadNominal = cantidad
    }
     fun operationWithCrypto(cryptoO: Crypto){
         this.cryptoActive = cryptoO
     }

     fun operationWithType(operationO : String){
         this.operationType = operationO
     }

    fun builder(): Operation {
        return Operation(Crypto().build(),2,User().builder(),"Compra")
    }


}