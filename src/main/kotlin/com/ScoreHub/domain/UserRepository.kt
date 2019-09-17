package com.ScoreHub.domain

interface UserRepository {
    fun store(user: User)
    fun findOneById(userid: String): User
    fun findOneByEmail(email: String): User
}