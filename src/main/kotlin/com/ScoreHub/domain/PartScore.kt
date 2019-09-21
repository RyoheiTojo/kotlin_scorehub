package com.ScoreHub.domain

class PartScore (
    val partName: String,
    val key: MusicKey,
    val midiprogram: Midiprogram,
    val chordNoteMax: Int,
    val scoreNotes: MutableList<Note>
)