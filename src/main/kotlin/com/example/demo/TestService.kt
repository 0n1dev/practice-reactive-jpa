package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class TestService(
    private val testRepository: TestRepository
) {

    @Transactional
    fun test(): Mono<Test> {
        val test = Test(
            "abc"
        )

        return testRepository.save(test)
    }
}