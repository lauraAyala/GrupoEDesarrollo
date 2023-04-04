package kotlin.GrupoE.Desarrollo.cryotoTes

import model.Crypto
import org.junit.Assert
import java.time.LocalDateTime

class CryptoTest {

    @Test
    fun cryptoWithNameNew(){

        var crypto = Crypto().build()

        cryptoWithNameNew("MATICUSDT")
        Assert.assertEquals(crypto.name, "MATICUSDT")
    }

    @Test
    fun cryptoWithDateNew(){

        var crypto = Crypto().build()
        var dateTime = LocalDateTime.of(2023,3,12,2,0)

        crypto.cryptoWithDate( dateTime)
        Assert.assertEquals(crypto.date, dateTime)
    }

    @Test
    fun cryptoWithQuoteNew(){

        var crypto = Crypto().build()
        crypto.cryptoWithQuote(24)
        Assert.assertEquals(crypto.cryptoQuote, 24)

}