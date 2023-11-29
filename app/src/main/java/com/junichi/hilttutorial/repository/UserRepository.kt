package com.junichi.hilttutorial.repository

import com.junichi.hilttutorial.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor() {
    // getUserが依存しているgetUsersを、UserRepositoryのコンストラクタで注入する
    fun getUser(id: Long): User? {
        return getUsers().find { it.id == id }
    }
    // getUserを使用して、依存性の注入をする
    fun getUsers(): List<User> {
        return listOf(
            User(id = 123, name = "James Bond", "jamesbond@007.com"),
            User(id = 345, name = "Batman", "batman@cave.com"),
            User(id = 999, name = "Arya Stark", "arya@winterfell.com")
        )
    }
}