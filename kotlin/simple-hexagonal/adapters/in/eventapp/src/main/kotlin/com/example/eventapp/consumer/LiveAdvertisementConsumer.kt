package com.example.eventapp.consumer

import com.example.domain.logger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

// 카프카와 같은 메시지 큐에 쌓이는 메시지를 컨슘하게 만들어야 하나, 요청을 쉽게 날려보면서 동작을 확인할 수 있도록 하기 위해 http 요청을 받는 컨트롤러로 제작했습니다.
@RestController
class LiveAdvertisementConsumer {

    private val logger = logger()

    @PostMapping("/live")
    fun liveEventConsumer() {
        logger.info("이벤트를 받아서 라이브 광고 요청 유즈케이스 호출")
    }
}
