package com.ScoreHub.domain

enum class NoteType (
    var id: Int
) {
    NORMAL_NOTE(0),
    REST_NOTE(1),
    SEPARATOR(2),
    SPACE(3),
    LOOP_FROM(4),
    LOOP_TO(5)
}
