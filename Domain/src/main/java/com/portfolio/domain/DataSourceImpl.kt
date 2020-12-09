package com.portfolio.domain

import javax.inject.Inject

/**
 * A good programmer writes code that can be understood
 * by humans
 */
class DataSourceImpl @Inject  constructor(): DataSource{
    override fun getData(): String {
        return "My name is domain module"
    }
}