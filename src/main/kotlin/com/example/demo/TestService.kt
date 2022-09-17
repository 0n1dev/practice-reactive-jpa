package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class TestService(
    private val testRepository: TestRepository
) {

    @Transactional
    suspend fun test(): Test {
        val test = Test(
            "테스트"
        )

        val savedTest = testRepository.save(test)

        savedTest.test = "아니야 바꿀꺼"

        return testRepository.save(savedTest)
    }
}