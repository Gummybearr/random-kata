package com.example.webapp.api.mapper

import com.example.core.Advertisement
import com.example.core.Description
import com.example.core.Image
import com.example.core.Title

data class CreateAdvertisementRequest(
    val title: String,
    val image: String,
    val description: String
) {
    fun toAdvertisement(): Advertisement {
        val title = Title(title = title)
        val image = Image(url = image)
        val description = Description(description = description)
        return Advertisement.new(title = title, image = image, description = description)
    }
}
