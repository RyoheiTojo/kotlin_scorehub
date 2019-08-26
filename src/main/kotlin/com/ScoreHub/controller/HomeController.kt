package com.ScoreHub.controller

import com.ScoreHub.ScoreHubLog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.ScoreHub.repogitory.RedisRepository
import com.library.logmessage.log

@RestController
@RequestMapping("home")
class HomeController {

    @Autowired
    lateinit var redisRepository: RedisRepository

    @GetMapping("/top")
    fun getTop(): String {
        redisRepository.redisCommands.setex("foo", 100, "bar")

        ScoreHubLog.TESTMSG1.log("key" to "value") {k,v -> print(k + v)}
        return "test"
    }
}
