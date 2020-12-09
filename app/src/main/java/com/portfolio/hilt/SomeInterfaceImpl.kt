package com.portfolio.hilt

import javax.inject.Inject

/**
 * A good programmer writes code that can be understood
 * by humans
 */
class SomeInterfaceImpl @Inject constructor() : SomeInterface{
    override fun getAThing(): String {
        return "look i someInterface thing"
    }
}