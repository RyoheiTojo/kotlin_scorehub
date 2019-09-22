package com.ScoreHub.domain

class NoteLength (
    val numerator: Int,
    val denomirator: Int
) {
    override fun toString(): String {
        return if (this.denomirator==0) "${this.numerator}" else "${this.numerator}/${this.denomirator}"
    }
}