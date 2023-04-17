package operationTest

import model.Crypto
import model.Operation
import model.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OperationTest {

    @Test
    fun operationWithCrypto(){
        var operation1 : Operation = Operation().builder()
        assertEquals(operation1.cryptoActive!!.name, "ALICEUSDT")
        var crypto2 : Crypto = Crypto().build()
        crypto2.cryptoWithName("ETHERIUM")
        operation1.operationWithCrypto(crypto2)
        assertEquals(operation1.cryptoActive!!.name, "ETHERIUM")
    }

    @Test
    fun operationWithCantidadNominal(){
        var operation1 : Operation = Operation().builder()
        operation1.operationWithCantidadNominal(3)
        assertEquals(operation1.cantidadNominal, 3)
    }

    @Test
    fun operationWithUser(){
        var operation1 : Operation = Operation().builder()
        var user1 : User = User().builder()
        operation1.operationWithUser(user1)
        assertEquals(operation1.user!!.name, "Laura")
    }

    @Test
    fun operationWithOperationType(){
        var operation1 : Operation = Operation().builder()
        operation1.operationWithType("Venta")
        assertEquals(operation1.operationType!!, "Venta")
    }



}