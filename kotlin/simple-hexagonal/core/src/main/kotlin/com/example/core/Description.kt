package com.example.core

import com.example.core.exception.CustomException

data class Description(val description: String) {
    companion object {
        private const val MINIMUM_LENGTH = 20

        operator fun invoke(description: String): Description {
            if (description.length < MINIMUM_LENGTH) {
                throw CustomException("설명이 너무 짧아요~")
            }
            return Description(description)
        }
    }
}