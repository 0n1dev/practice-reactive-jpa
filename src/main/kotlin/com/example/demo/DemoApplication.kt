package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import reactor.blockhound.BlockHound

@SpringBootApplication
@EnableR2dbcRepositories
class DemoApplication

fun main(args: Array<String>) {
    BlockHound.install()

    runApplication<DemoApplication>(*args)
}
