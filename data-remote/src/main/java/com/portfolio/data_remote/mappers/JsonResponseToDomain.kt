package com.portfolio.data_remote.mappers

import com.portfolio.data_remote.models.Post


fun Post.toDomain() = com.portfolio.domain.data.entities.Post(
    id, title, body, userId
)