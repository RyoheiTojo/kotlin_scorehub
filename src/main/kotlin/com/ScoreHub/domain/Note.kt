package com.ScoreHub.domain

data class Note (
    val pitch: Int,  // C major C,=0  half-tone(+1)# C major C,=0  half-tone(+1)
    val noteType: NoteType,
    val hasSlur: Boolean,
    val length: Int,
    val accidentalType: AccidentalType,
    val mark: String
)
