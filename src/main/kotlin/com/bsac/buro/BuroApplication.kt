package com.bsac.buro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BuroApplication

fun main(args: Array<String>) {
	runApplication<BuroApplication>(*args)
}
