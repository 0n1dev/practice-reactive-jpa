package com.example.demo

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@Service
class TestService(
    private val testRepository: TestRepository
) {

    fun test() {
        val test = Test(
            "abc"
        )

        testRepository.save(test)
    }
}