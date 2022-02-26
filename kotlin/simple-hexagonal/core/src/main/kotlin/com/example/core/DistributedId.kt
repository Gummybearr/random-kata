package com.example.core

import kotlin.random.Random

class DistributedId {
    companion object {
        fun nextId(): Long {
            // 분산아이디를 생성해서 준다고 가정
            return Random(0).nextLong()
        }
    }
}
