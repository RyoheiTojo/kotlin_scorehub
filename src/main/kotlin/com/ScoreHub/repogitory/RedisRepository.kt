package com.ScoreHub.repogitory

import io.lettuce.core.RedisClient
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.sync.RedisCommands
import org.springframework.stereotype.Repository

@Repository
class RedisRepository (redisProperties: RedisProperties) {

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

}