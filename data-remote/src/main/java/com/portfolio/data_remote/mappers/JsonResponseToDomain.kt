package com.portfolio.data_remote.mappers

import com.portfolio.data_remote.models.Post

/**
 * A good programmer writes code that can be understood
 * by humans
 */

fun Post.toDomain() = com.portfolio.domain.data.entities.Post(
    id, title, body, userId
)