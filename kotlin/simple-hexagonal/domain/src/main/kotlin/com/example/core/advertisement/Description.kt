package com.example.core.advertisement

import com.example.core.exception.CustomException

data class Description(val description: String) {
    companion object {
        private const val MINIMUM_LENGTH = 20
    }

    init {
        validate(description)
    }

    private fun validate(description: String) {
        if (description.length < MINIMUM_LENGTH) {
            throw CustomException("설명이 너무 짧아요~")
        }
    }
}
