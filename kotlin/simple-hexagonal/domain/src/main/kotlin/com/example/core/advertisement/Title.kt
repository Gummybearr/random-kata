package com.example.core.advertisement

import com.example.core.exception.CustomException

data class Title(
    val title: String
) {

    companion object {
        private const val MINIMUM_LENGTH = 5
    }

    init {
        validate(title)
    }

    private fun validate(title: String) {
        if (title.length < MINIMUM_LENGTH) {
            throw CustomException("광고 제목이 너무 짧아요")
        }
    }
}
