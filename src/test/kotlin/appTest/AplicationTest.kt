package appTest

import model.Aplication
import model.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class AplicationTest {

    @Test
    fun aplicationRegisterAUser(){

        var api: Aplication= Aplication()
        var user1:User = User().builder()

        api.userRegister(user1)
        assertEquals(api.listUsers.size,1)
    }
}