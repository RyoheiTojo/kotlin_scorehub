package com.library.logmessage

interface LogMessage {
    val messageId: String
    val message: String
}

fun com.library.logmessage.LogMessage.log(p: Pair<String, String>, block:(String, String) -> Unit) {
   block.invoke("[${this.messageId}] ${this.message}", genMessage(p))
}

fun genMessage(p: Pair<String, String>): String{
    return "${p.first}=${p.second}"
}
