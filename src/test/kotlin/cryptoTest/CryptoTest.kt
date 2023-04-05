package cryptoTest

import model.Crypto

import java.time.LocalDateTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CryptoTest {

    @Test
    fun cryptoWithNameNew() {

        var crypto = Crypto().build()

        crypto.cryptoWithName("MATICUSDT")
        assertEquals(crypto.name, "MATICUSDT")
    }

    @Test
    fun cryptoWithDateNew() {

        var crypto = Crypto().build()
        var dateTime = LocalDateTime.of(2023, 3, 12, 2, 0)

        crypto.cryptoWithDate(dateTime)
        assertEquals(crypto.date, dateTime)
    }

    @Test
    fun cryptoWithQuoteNew() {

        var crypto = Crypto().build()
        crypto.cryptoWithQuote(24)
        assertEquals(crypto.cryptoQuote, 24)

    }
}