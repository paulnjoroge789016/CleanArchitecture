package com.portfolio.data_remote.mappers


fun Post.toDomain() = com.portfolio.domain.data.entities.Post(
    id, title, body, userId
)