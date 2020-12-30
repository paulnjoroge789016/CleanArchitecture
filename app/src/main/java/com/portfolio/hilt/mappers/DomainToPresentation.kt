package com.portfolio.hilt.mappers

import com.portfolio.domain.data.entities.Post


fun Post.toPresentation() = com.portfolio.hilt.models.Post(
    body, title
)