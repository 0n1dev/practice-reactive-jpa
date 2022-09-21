package com.example.demo

import io.smallrye.mutiny.coroutines.awaitSuspending
import org.hibernate.reactive.mutiny.Mutiny.fetch
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TestService(
    private val testRepository: TestRepository
) {

    suspend fun createTest(): TestResponse {

        val test = Test(
            test = "테스트"
        )

        val savedTest = testRepository.save(test).awaitSuspending()

        for (i in 1..5) {
            val subTest = SubTest(
                subTest = "테스트2 - $i",
                test = savedTest
            )

            savedTest.addList(subTest)
        }

        return TestResponse.of(testRepository.save(savedTest).awaitSuspending())
    }

    suspend fun getTests(): MutableList<Test>? {
        return testRepository.findAll()?.awaitSuspending()
    }

    suspend fun getTest(id: Long): TestResponse {
        return TestResponse.of(testRepository.findById(id).awaitSuspending())
    }

    suspend fun deleteTest(id: Long) {
        testRepository.deleteById(id)?.awaitSuspending()
    }

    suspend fun updateTest(id: Long): Test {
        val test = Test(
            test = "테스트2",
            id = id
        )

        return testRepository.save(test).awaitSuspending()
    }
}