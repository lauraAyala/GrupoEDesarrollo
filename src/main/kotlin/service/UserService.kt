package service

import dto.UserDto
import model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.UserReposiory

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserReposiory

    fun createUser(user: User): User {

        val user = userRepository.save(user)

        return user

    }
    fun updateUser(user: User){

        userRepository.saveAndFlush(user)

    }
    fun recoverUser(id: Long): User{

        return userRepository.getOne(id)

    }

    fun allUsers(): MutableList<User> {

        return userRepository.findAll()

    }
    fun deleteUserByName(name: String?): MutableList<User> {
        userRepository.deleteByName(name)
        return this.allUsers()
    }

    fun login(email: String, password: String): UserDto {

        try {
            var  user  = userRepository.login(email, password)
            val userDto = UserDto(user?.name!!)


            return userDto

        }
        catch ( e:Exception) {
            throw Exception("the email or password is incorrect");
        }
    }

}