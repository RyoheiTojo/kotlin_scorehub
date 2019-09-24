package com.ScoreHub.domain

interface ScoreNoteConverter {
    fun convertToScoreNotes(score: String)
    fun convertFromScoreNotes(): String
}