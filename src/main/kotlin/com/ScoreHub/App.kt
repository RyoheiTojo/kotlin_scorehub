/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.ScoreHub

import com.ScoreHub.application.MessageScheduler
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@SpringBootApplication
open class App {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args).getBean(App::class.java).run()
        }
    }
    fun run() {
        print("main routing start!")
        val executor: ExecutorService = Executors.newFixedThreadPool(1)
        executor.submit(MessageScheduler())

        print("main routing finish!")
    }
}