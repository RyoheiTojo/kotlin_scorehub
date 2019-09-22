package com.ScoreHub.domain

class MusicScore (
    val title: String,
    val musicKey: MusicKey,
    val length: NoteLength,
    val beat: Beat,
    val composer: String,
    val bpm: Bpm,
    val postEpochTime: Long,
    val updateEpochTime: Long,
    val partScores: MutableList<PartScore>
)