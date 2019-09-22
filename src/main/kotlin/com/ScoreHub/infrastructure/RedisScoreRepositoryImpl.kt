package com.ScoreHub.infrastructure

import com.ScoreHub.domain.MusicScore
import com.ScoreHub.domain.ScoreRepository
import org.springframework.stereotype.Repository

@Repository
class RedisScoreRepositoryImpl (redisProperties: RedisProperties): ScoreRepository {
    override fun store(musicScore: MusicScore) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(scoreid: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}