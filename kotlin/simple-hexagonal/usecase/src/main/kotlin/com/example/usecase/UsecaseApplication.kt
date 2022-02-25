package com.example.usecase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UsecaseApplication

fun main(args: Array<String>) {
    runApplication<UsecaseApplication>(*args)
}
