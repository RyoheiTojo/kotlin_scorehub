package ScoreHub.repogitory

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "redis")
class RedisProperties {
    lateinit var url: String
}

