package com.example.eventapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "com.example.eventapp",
        "com.example.application",
        "com.example.external",
        "com.example.persistence"
    ]
)
class EventappApplication

fun main(args: Array<String>) {
    runApplication<EventappApplication>(*args)
}
