package com.ScoreHub.domain

enum class Midiprogram (
    val midigroup: Midigroup,
    val description: String
) {
    ACCOUSTIC_PIANO(Midigroup.PIANO, "Accoustic Piano"),
    BRIGHT_PIANO(Midigroup.PIANO, "Bright Piano"),
    ELECTRIC_GRAND_PIANO(Midigroup.PIANO, "Electric Grand Piano"),
    HONKEY_TONK_PIANO(Midigroup.PIANO, "Honky-tonk Piano");

    enum class Midigroup {
        PIANO,
        CHROMATIC_PERCUSSION,
        ORGAN,
        GUITAR,
        BASS,
        STRINGS,
        ENSEMBLE,
        BRASS,
        REED,
        PIPE,
        SYNTH_LEAD,
        SYNTH_PAD,
        SYNTH_EFFECTS,
        ETHNIC,
        PERCUSSIVE,
        SOUND_EFFECTS
    }
}