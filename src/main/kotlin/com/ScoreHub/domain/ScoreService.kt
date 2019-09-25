package com.ScoreHub.domain

import org.springframework.beans.factory.annotation.Autowired

class ScoreService {
    @Autowired
    lateinit var scoreRepository: ScoreRepository

    @Autowired
    lateinit var scoreNoteConverter: ScoreNoteConverter

}