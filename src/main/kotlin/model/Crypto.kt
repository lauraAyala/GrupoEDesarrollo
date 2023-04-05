package model

import java.time.LocalDateTime

class Crypto (){

    var operation: String? = null
    var name: String?=null
    var date:LocalDateTime?= null
    var cryptoQuote: Int?= null
    var amountOfTheCrypto: Int?= null
    var amountOfTheOperation: Int?= null

    constructor(nameC: String, dateC: LocalDateTime, cryptoQ:Int) : this() {

        this.name = nameC
        this.date = dateC
        this.cryptoQuote = cryptoQ
    }
    fun cryptoWithName(nameC: String){

        this.name = nameC
    }

    fun cryptoWithDate(dateC: LocalDateTime){

        this.date = dateC
    }

    fun cryptoWithQuote(quote:Int){

        this.cryptoQuote = quote
    }

    fun build() :Crypto{

        var crypto = Crypto("ALICEUSDT", LocalDateTime.now(),0)
        return crypto
    }
}
