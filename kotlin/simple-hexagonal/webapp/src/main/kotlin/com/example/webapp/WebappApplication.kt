package com.example.webapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "com.example.webapp",
        "com.example.adapter",
        "com.example.usecase"
    ]
)
class WebappApplication

fun main(args: Array<String>) {
    runApplication<WebappApplication>(*args)
}
