package com.ScoreHub.domain

enum class AccidentalType (
    var id: Int
) {
    NONE(0),
    DOBBLE_SHARP(1),
    SHARP(2),
    NATURAL(3),
    FLAT(4),
    DOBBLE_FLAT(5)
}