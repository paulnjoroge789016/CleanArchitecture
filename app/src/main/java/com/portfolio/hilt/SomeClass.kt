package com.portfolio.hilt

import com.portfolio.domain.DataSource
import javax.inject.Inject

/**
 * A good programmer writes code that can be understood
 * by humans
 */
class SomeClass @Inject constructor(private val someInterfaceImpl: SomeInterface, private val dataSource: DataSource) {
    fun doAThing() = "Look I did a Thing\n" + someInterfaceImpl.getAThing() + "\n From Domain ${dataSource.getData()}"}
