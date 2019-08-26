package com.library.logmessage

interface LogMessage {
    val messageId: String
    val message: String
}

fun com.library.logmessage.LogMessage.log(p: Pair<String, Any?>, block:(String, String) -> Unit) {
   block.invoke(this.messageId, this.message)
}
