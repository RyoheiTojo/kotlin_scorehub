package com.ScoreHub.domain

import com.ScoreHub.domain.User
import com.ScoreHub.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var userStore: UserRepository

    fun registUser(email: Email, password: Password) {
        userStore.store( User("hogehoge", 0, password, email))
    }

}