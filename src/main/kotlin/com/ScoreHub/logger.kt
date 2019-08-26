package com.ScoreHub

import com.library.logmessage.LogMessage

enum class ScoreHubLog(
    override val messageId: String,
    override val message: String
): LogMessage {
    TESTMSG1("Test1", "msg1"),
    TESTMSG2("Test2", "msg2")
}