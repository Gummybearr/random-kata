package com.example.core

enum class Violation(val code: Int, val message: String) {
    INAPPROPRIATE_IMAGE(1, "사진이 부적합해요"),
    INAPPROPRIATE_TITLE(2, "제목이 부적합해요"),
    INAPPROPRIATE_DESCRIPTION(3, "내용이 부적합해요")
}