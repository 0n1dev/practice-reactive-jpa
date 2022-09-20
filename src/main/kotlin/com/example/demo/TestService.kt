package com.example.demo

import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class TestService(
    private val testRepository: TestRepository
) {

    suspend fun createTest(): Test {
        val test = Test(
            "테스트"
        )

        return testRepository.save(test)
    }

    suspend fun getTests(): List<Test> {
        return testRepository.findAll().toList()
    }

    suspend fun getTest(id: Long): Test {
        return testRepository.findById(id) ?: kotlin.run { throw RuntimeException() }
    }

    suspend fun deleteTest(id: Long) {
        testRepository.deleteById(id)
    }

    suspend fun updateTest(id: Long): Test {
        val test = Test(
            "테스트2",
            id
        )

        return testRepository.save(test)
    }
}