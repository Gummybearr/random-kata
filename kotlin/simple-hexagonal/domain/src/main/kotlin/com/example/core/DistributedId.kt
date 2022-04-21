package com.example.core

import net.jcip.annotations.GuardedBy

class DistributedId {
    companion object {

        @GuardedBy("this")
        private var id = 1L

        @Synchronized
        fun nextId(): Long {
            // 분산아이디를 생성해서 준다고 가정
            return id++
        }
    }
}
