package com.example.data.entity

import com.example.core.*

// Entity
class Advertisement(
    //저장시 컨버터에 의해 변환된다고 가정!
    val id: AdvertisementId,
    val title: Title,
    val image: Image,
    val description: Description,
    val status: AdvertisementStatus
)