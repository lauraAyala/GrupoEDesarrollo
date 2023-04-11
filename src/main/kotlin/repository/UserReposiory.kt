package repository

import model.User
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.FluentQuery
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.util.*
import java.util.function.Function

interface UserReposiory : JpaRepository<User,Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM user WHERE nameUser = :name", nativeQuery = true)
    fun deleteByName(@Param("name") name: String?)

    @Query(value = "SELECT * FROM user WHERE email =:mail AND password =:pass LIMIT 1", nativeQuery = true)
    fun login(@Param ("mail" )email: String,@Param ("pass") password: String): User?

    @Query(value = "SELECT * FROM user WHERE name_User = :name LIMIT 1",nativeQuery = true)
    fun recoverUser(@Param("name") name: String): User?

}