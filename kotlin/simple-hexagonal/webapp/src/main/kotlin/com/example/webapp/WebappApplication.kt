package com.example.webapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "com.example.webapp",
        "com.example.usecase",
        "com.example.adapter"
    ]
)
class WebappApplication

fun main(args: Array<String>) {
    runApplication<WebappApplication>(*args)
}
