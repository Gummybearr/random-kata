package com.example.data.entity

import com.example.core.AdvertisementId
import com.example.core.Description
import com.example.core.Image
import com.example.core.Title

// Entity
class Advertisement(
    //저장시 컨버터에 의해 변환된다고 가정!
    val id: AdvertisementId,
    val title: Title,
    val image: Image,
    val description: Description
)