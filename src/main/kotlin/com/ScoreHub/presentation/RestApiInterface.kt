package com.ScoreHub.presentation

import com.ScoreHub.ScoreHubLog
import com.ScoreHub.domain.Email
import com.ScoreHub.domain.Password
import com.ScoreHub.domain.UserService
import com.ScoreHub.infrastructure.RedisUserRepositoryImpl
import com.library.logmessage.log
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.*

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
    fun createScore(@RequestBody @Validated scoreData: ScoreData) {
        println(scoreData.beat)
        println(scoreData.partScores?.get(0)?.abcdata)
    }

}

data class ScoreData(
    @field:NotEmpty(message = "Must not be empty.")
    val title: String?,

    @field:NotEmpty(message = "Must not be empty.")
    @field:Pattern(regexp = "^Cb|Gb|Db|Ab|Eb|Bb|F|C|G|D|A|E|B|F#|C#$", message = "Unexpected format.")
    val musicKey: String?,


    @field:NotEmpty(message = "Must not be empty.")
    @field:Pattern(regexp = "^[0-9]+/[0-9]+$", message = "Unexpected format.")
    val length: String?,

    @field:NotEmpty(message = "Must not be empty.")
    @field:Pattern(regexp = "^[0-9]+/[0-9]+$", message = "Unexpected format.")
    val beat: String?,

    @field:NotEmpty(message = "Must not be empty.")
    val composer: String?,

    @field:Positive(message = "Must be postive number.")
    val bpm: Int?,

    @field:NotNull(message = "Must not be null.")
    @field:Valid
    val partScores: List<PartScoreData>?
)

data class PartScoreData (
    @field:NotEmpty(message = "Must not be empty.")
    val partName: String?,

    @field:NotEmpty(message = "Must not be empty.")
    @field:Pattern(regexp = "^Cb|Gb|Db|Ab|Eb|Bb|F|C|G|D|A|E|B|F#|C#$", message = "Unexpected format.")
    val key: String?,

    @field:Min(value = 0, message = "Must be positive.")
    @field:Max(value = 128, message = "Must be between 0 to 128")
    val midiprogram: Long?,

    @field:NotNull(message = "Must not be null.")
    val abcdata: String?
)

data class Loginform(
    val email: String,
    val password: String
)
