package com.example.core

import com.example.core.exception.CustomException

data class Title(
    val title: String
) {

    companion object {
        private const val MINIMUM_LENGTH = 5

        operator fun invoke(title: String): Title {
            if (title.length < MINIMUM_LENGTH) {
                throw CustomException("광고 제목이 너무 짧아요")
            }
            return Title(title = title)
        }
    }
}
