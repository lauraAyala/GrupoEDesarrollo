package kotlin.GrupoE.Desarrollo.aplicationTest

import model.Aplication
import model.User

class AplicationTest {

    @Test
    fun aplicationRegisterAUser(){

        var api: Aplication= Aplication()
        var user1:User = User().builder()

        api.userRegister(user1)
        Assert.assertEquals(api.listUsers.size,1)
    }
}