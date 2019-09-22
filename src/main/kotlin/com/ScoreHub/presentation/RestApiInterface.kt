package com.ScoreHub.presentation

import com.ScoreHub.ScoreHubLog
import com.ScoreHub.domain.Email
import com.ScoreHub.domain.Password
import com.ScoreHub.domain.UserService
import com.ScoreHub.infrastructure.RedisUserRepositoryImpl
import com.library.logmessage.log
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserController(val log: Logger) {

    @Autowired
    lateinit var redisRepository: RedisUserRepositoryImpl

    @Autowired
    lateinit var usermanagement: UserService

    @PostMapping("regist")
    fun registUser(@RequestBody loginform: Loginform) {
        println(loginform.email)
        println(loginform.password)
        usermanagement.registUser(Email(loginform.email), Password(loginform.password))
    }

    @GetMapping("/top")
    fun getTop(): String {
        redisRepository.redisCommands.setex("foo", 100, "bar")

        ScoreHubLog.TESTMSG1.log("key" to "value") { k, v -> log.info(k + v)}
        return "test"
    }
}

@RestController
@RequestMapping("score")
class ScoreController(val log: Logger) {

    @PostMapping("create")
    fun createScore(@RequestBody scoreData: ScoreData) {
        println(scoreData.beat)
        println(scoreData.partScores[0].abcdata)
    }

}

data class ScoreData(
    val title: String,
    val musicKey: String,
    val length: String,
    val beat: String,
    val composer: String,
    val bpm: String,
    val partScores: List<PartScoreData>
)

data class PartScoreData (
    val partName: String,
    val key: String,
    val midiprogram: String,
    val abcdata: String
)

data class Loginform(
    val email: String,
    val password: String
)
