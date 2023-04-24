package com.example.demo.model

open class Operation (){

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




}