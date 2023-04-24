package operationTest

import com.example.demo.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class OperationTest {

    @Test
    fun operationWithCrypto(){
        var operation1 : OperationBuilder = OperationBuilder().builder()
        var crypto1 : CryptoBuilder = CryptoBuilder().build()
        crypto1.cryptoWithName("ETHERIUM")
        operation1.operationWithCrypto(crypto1)
        assertEquals(operation1.cryptoActive!!.name, "ETHERIUM")
    }

    @Test
    fun operationWithCantidadNominal(){
        var operation1 : OperationBuilder = OperationBuilder().builder()
        operation1.operationWithCantidadNominal(3)
        assertEquals(operation1.cantidadNominal, 3)
    }

    @Test
    fun operationWithUser(){
        var operation1 : OperationBuilder = OperationBuilder().builder()
        var user1 : UserBuilder = UserBuilder().builder()
        user1.whitName("Laura")
        operation1.operationWithUser(user1)
        assertEquals(operation1.user!!.name, "Laura")
    }

    @Test
    fun operationWithOperationType(){
        var operation1 : OperationBuilder = OperationBuilder().builder()
        operation1.operationWithType("Venta")
        assertEquals(operation1.operationType!!, "Venta")
    }



}