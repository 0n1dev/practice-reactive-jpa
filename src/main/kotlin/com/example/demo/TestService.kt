package com.example.demo

import io.smallrye.mutiny.coroutines.awaitSuspending
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TestService(
    private val testRepository: TestRepository
) {

    suspend fun createTest(): Test {
        val test = Test(
            "테스트"
        )

        return testRepository.save(test).awaitSuspending()
    }

    suspend fun getTests(): MutableList<Test>? {
        return testRepository.findAll()?.awaitSuspending()
    }

    suspend fun getTest(id: Long): Test {
        return testRepository.findById(id).awaitSuspending()
    }

    suspend fun deleteTest(id: Long) {
        testRepository.deleteById(id)?.awaitSuspending()
    }

    suspend fun updateTest(id: Long): Test {
        val test = Test(
            "테스트2",
            id
        )

        return testRepository.save(test).awaitSuspending()
    }
}