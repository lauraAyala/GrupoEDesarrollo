package kotlin.GrupoE.Desarrollo.userTest

import model.Crypto
import model.User
import org.junit.Assert

class UserTest {

    @Test
    fun userWithName(){
        var user1: User = User().builder()
        user1.whitName("Laura")

        Assert.assertEquals(user1.name, "Laura")

    }

    @Test
    fun userWithLasName(){

        var user1: User = User().builder()
        user1.withLastName("ayala")

        Assert.assertEquals(user1.name, "ayala")


    }

    @Test
    fun userWithEmailAndPassword(){

        var user1: User = User().builder()
        user1.withEmail("layala@gmail")
        user1.withPassword("1234")

        Assert.assertEquals(user1.email, "layala@gmail")
        Assert.assertEquals(user1.email, "1234")

    }

    @Test
    fun userWithDirection(){

        var user1: User = User().builder()
        user1.withDirection("alen 123")
        Assert.assertEquals(user1.direction, "alen 123")

    }

    @Test
    fun userIsntCriptos(){

        var user1: User = User().builder()
        Assert.assertEquals(user1.cryptos.size, 0)
    }

    @Test
    fun userWithOneCripto(){

        var user1: User = User().builder()
        var cryptoA: Crypto = Crypto.build()
        user1.addCryptoActivity(cryptoA)
        Assert.assertEquals(user1.cryptos.size, 1)
    }






}