package cryptoTest

import com.example.demo.model.CryptoBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class CryptoTest {

    @Test
    fun cryptoWithNameNew() {

        var crypto = CryptoBuilder().build()
        crypto.cryptoWithName("MATICUSDT")
        Assertions.assertEquals(crypto.name, "MATICUSDT")
    }

    @Test
    fun cryptoWithDateNew() {

        var crypto = CryptoBuilder().build()
        var dateTime = LocalDateTime.of(2023, 4, 18, 3, 46)//.toString()

        crypto.cryptoWithDate(dateTime)
        Assertions.assertEquals(crypto.date, dateTime)
    }

    @Test
    fun cryptoWithQuoteNew() {

        var crypto = CryptoBuilder().build()
        crypto.cryptoWithQuote(24.0)
        Assertions.assertEquals(crypto.quote, 24.0)

    }
}