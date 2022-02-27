package com.example.eventapp.consumer

import com.example.eventapp.consumer.mapper.BlockAdvertisementEvent
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

// 카프카와 같은 메시지 큐에 쌓이는 메시지를 컨슘하게 만들어야 하나, 요청을 쉽게 날려보면서 동작을 확인할 수 있도록 하기 위해 http 요청을 받는 컨트롤러로 제작했습니다.
@RestController
class BlockAdvertisementConsumer(
//    val blockAdvertisement
) {

    @PostMapping("/block")
    fun blockEventConsumer(@RequestBody blockAdvertisementEvent: BlockAdvertisementEvent) {
    }
}
