package com.ScoreHub.infrastructure

import com.ScoreHub.domain.User
import com.ScoreHub.domain.UserRepository
import io.lettuce.core.RedisClient
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.sync.RedisCommands
import org.springframework.stereotype.Repository

@Repository
class RedisUserRepositoryImpl (redisProperties: RedisProperties): UserRepository {

    companion object {
        const val USERNAME_PREFIX = "user:"
        const val USERID = "userid:"
    }

    var redisCommands: RedisCommands<String, String>
    var redisConnection: StatefulRedisConnection<String, String>
    var redisClient: RedisClient = RedisClient.create(redisProperties.url)

    init {
        this.redisConnection = redisClient.connect()
        this.redisCommands = redisConnection.sync()
    }

    fun setKey() {
        this.redisCommands.setex("foo", 100, "bar")
    }

    fun closeConnection() {
        this.redisConnection.close()
        this.redisClient.shutdown()
    }

    override fun store(user: User) {
        val nextid = if(user.userid != 0L) user.userid else this.redisCommands.incr("${USERID}")
        this.redisCommands.hmset("${USERNAME_PREFIX}${user.username}", mapOf("email" to user.email, "password" to user.password, "userid" to "${nextid}"))
    }

    override fun findOneById(userid: String): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findOneByEmail(email: String): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}