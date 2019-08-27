package com.ScoreHub

import com.library.logmessage.LogMessage
import org.slf4j.LoggerFactory.*
import org.slf4j.Logger
import org.springframework.beans.factory.BeanCreationException
import org.springframework.beans.factory.InjectionPoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

enum class ScoreHubLog(
    override val messageId: String,
    override val message: String
): LogMessage {
    TESTMSG1("TESTMSGID1", "This is my Msg Test1: "),
    TESTMSG2("TESTMSGID2", "This is my Msg Test2: ")
}

@Configuration
open class LoggerInjectionConfig {
    @Bean
    @Scope("prototype")
    open fun logger(ip: InjectionPoint): Logger {
        return getLogger(ip.methodParameter?.containingClass
            ?:ip.field?.declaringClass
            ?:throw BeanCreationException("Cannot find type for Logger"))
    }

}