package userTest

import com.example.demo.model.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class UserTest {

    @Test
    fun userWithName(){
        var user1: UserBuilder = UserBuilder().builder()
        user1.whitName("Laura")
        Assertions.assertEquals(user1.name, "Laura")

    }
    @Test
    fun userWithLasName(){

        var user1: UserBuilder = UserBuilder().builder()
        user1.withLastName("ayala")

        Assertions.assertEquals(user1.lastName, "ayala")


    }

    @Test
    fun userWithEmailAndPassword(){

        var user1: UserBuilder = UserBuilder().builder()
        user1.withEmail("layala@gmail")
        user1.withPassword("1234")

        Assertions.assertEquals(user1.email, "layala@gmail")
        Assertions.assertEquals(user1.password, "1234")

    }

    @Test
    fun userWithDirection(){

        var user1: UserBuilder = UserBuilder().builder()
        user1.withDirection("alen 123")
        Assertions.assertEquals(user1.direction, "alen 123")

    }

    @Test
    fun userIsntCriptos(){

        var user1: UserBuilder = UserBuilder().builder()
        Assertions.assertEquals(user1.cryptos!!.size, 0)
    }

   @Test
    fun userWithOneCripto(){

        var user1: UserBuilder = UserBuilder().builder()
        var cryptoA: CryptoBuilder = CryptoBuilder().build()
        user1.addCryptoActivity(cryptoA)
        Assertions.assertEquals(user1.cryptos.size, 1)
       Assertions.assertEquals(user1.cryptos.get(0), cryptoA)

   }

    @Test
    fun userRealizedSaleThereIsAddInApp(){

        var user1 : User=  User("Laura","ayala","layala","1234","c123","12345678")
        var cryptoA=  Crypto("ALICEUSDT", LocalDateTime.now(),200.0)
        var operation = user1.saleCrypto(cryptoA)

        equals(operation.userCreated!! == user1)
        assert(operation.userCreated!!.state =="waiting")

    }

    @Test
    fun userRealizedSaleThereIsRealized(){

        var user1 : User=  User("Laura","ayala","layala","1234","c123","12345678")
        var user2 : User=  User("Julian","Bernal","jbernal","567","j123","9435")
        var cryptoA=  Crypto("ALICEUSDT", LocalDateTime.now(),200.0)
        var oper : Operation = user1.saleCrypto(cryptoA)
        oper.updateUserInterested(user2)

        assert(oper.userCreated == user1)
        assert(oper.userInterested == user2)
        assert(oper.userInterested!!.reception)
    }
    @Test
    fun userRealizedBuyThereIsRealized(){

        var user1 : User=  User("Laura","ayala","layala","1234","c123","12345678")
        var user2 : User=  User("Julian","Bernal","jbernal","567","j123","9435")
        var cryptoA=  Crypto("ALICEUSDT", LocalDateTime.now(),200.0)
        var oper : Operation = user1.saleCrypto(cryptoA)
        oper = oper.updateUserInterested(user2)
        var operBuy= user2.buyCrypto(oper)


        assert(operBuy.userCreated == user2)
        assert(operBuy.userInterested == user1)
        assert(operBuy.userInterested!!.reception)
        assert(operBuy.userInterested!!.point == 5)
    }

    @Test
    fun user1CanceledOperationIsRstartPoints(){

        var user1 : User=  User("Laura","ayala","layala","1234","c123","12345678")
        var user2 : User=  User("Julian","Bernal","jbernal","567","j123","9435")
        user1 = user1.sumPoint(20)
        var cryptoA=  Crypto("ALICEUSDT", LocalDateTime.now(),200.0)
        var oper : Operation = user1.saleCrypto(cryptoA)
        oper = oper.updateUserInterested(user2)
        oper= oper.userCreated!!.canceledOperation(oper)

        assert(oper.userCreated!!.point == 0)

    }




}