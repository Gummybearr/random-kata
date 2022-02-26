package com.example.core

import com.example.core.exception.CustomException

data class Image(val url: String) {

    companion object {
        private const val VALID_URL = "address in s3 bucket"
    }

    init {
        validate(url)
    }

    private fun validate(url: String) {
        if (url != VALID_URL) {
            throw CustomException("사진이 이상해요")
        }
    }
}
