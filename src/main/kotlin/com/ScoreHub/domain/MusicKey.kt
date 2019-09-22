package com.ScoreHub.domain

enum class MusicKey (
    val mark: String,
    val basePitch: Int
) {
    C ("C", 0),
    C_SHARP ("C#", 1),
    D_FLAT ("Db", 1),
    D ("D", 2),
    E_FLAT ("Eb", 3),
    E ("E", 4),
    F ("F", 5),
    G_FLAT ("Gb", 5),
    F_SHARP ("F#", 6),
    G ("G", 7),
    A_FLAT ("Ab", 8),
    A ("A", 9),
    B_FLAT ("Bb", 10),
    B ("B", 11),
    C_FLAT ("Cb", 11)
}