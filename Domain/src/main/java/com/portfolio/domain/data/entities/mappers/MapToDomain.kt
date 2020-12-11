package com.portfolio.domain.data.entities.mappers

import com.portfolio.domain.data.entities.network.Post


fun Post.toDomain() = com.portfolio.domain.data.entities.domain.Post(
    id, title, body, userId
)
