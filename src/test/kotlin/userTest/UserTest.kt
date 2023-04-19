package userTest

import com.example.demo.model.Crypto
import com.example.demo.model.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UserTest {

    @Test
    fun userWithName(){
        var user1: User = User().builder()
        user1.whitName("Laura")
        Assertions.assertEquals(user1.name, "Laura")

    }
    @Test
    fun userWithLasName(){

        var user1: User = User().builder()
        user1.withLastName("ayala")

        Assertions.assertEquals(user1.lastName, "ayala")


    }

    @Test
    fun userWithEmailAndPassword(){

        var user1: User = User().builder()
        user1.withEmail("layala@gmail")
        user1.withPassword("1234")

        Assertions.assertEquals(user1.email, "layala@gmail")
        Assertions.assertEquals(user1.password, "1234")

    }

    @Test
    fun userWithDirection(){

        var user1: User = User().builder()
        user1.withDirection("alen 123")
        Assertions.assertEquals(user1.direction, "alen 123")

    }

    @Test
    fun userIsntCriptos(){

        var user1: User = User().builder()
        Assertions.assertEquals(user1.cryptos!!.size, 0)
    }

   /* @Test
    fun userWithOneCripto(){

        var user1: User = User().builder()
        var cryptoA: Crypto = Crypto().build()
        user1.addCryptoActivity(cryptoA)
        Assertions.assertEquals(user1.cryptos.size, 1)
    }

    */
}