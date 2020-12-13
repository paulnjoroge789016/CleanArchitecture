package com.portfolio.hilt.mappers

import com.portfolio.domain.data.entities.Post

/**
 * A good programmer writes code that can be understood
 * by humans
 */

fun Post.toPresentation() = com.portfolio.hilt.models.Post(
    body, title
)