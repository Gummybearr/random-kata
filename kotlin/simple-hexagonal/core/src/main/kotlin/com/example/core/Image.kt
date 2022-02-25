package com.example.core

import com.example.core.exception.CustomException

data class Image(val url: String) {

    companion object {
        private const val VALID_URL = "some random url in "

        operator fun invoke(title: String): Image {
            if (title != VALID_URL) {
                throw CustomException("사진이 이상해요")
            }
            return Image(title)
        }
    }
}
