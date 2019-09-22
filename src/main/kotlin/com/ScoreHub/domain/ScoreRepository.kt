package com.ScoreHub.domain

interface ScoreRepository {
    fun store(musicScore: MusicScore)
    fun findById(scoreid: Long)
}