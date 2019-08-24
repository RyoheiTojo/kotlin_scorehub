package ScoreHub

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ScoreHub.repogitory.RedisRepository

@RestController
@RequestMapping("home")
class HomeController {

    @Autowired
    lateinit var redisRepository: RedisRepository

    @GetMapping("/top")
    fun getTop(): String {
        redisRepository.redisCommands.setex("foo", 100, "bar")
        return "test"
    }
}
