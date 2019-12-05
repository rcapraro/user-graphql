package com.capraro.usergraphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserGraphqlApplication

fun main(args: Array<String>) {
    runApplication<UserGraphqlApplication>(*args)
}
