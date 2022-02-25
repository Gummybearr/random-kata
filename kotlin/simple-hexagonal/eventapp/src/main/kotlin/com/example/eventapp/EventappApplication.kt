package com.example.eventapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventappApplication

fun main(args: Array<String>) {
    runApplication<EventappApplication>(*args)
}
