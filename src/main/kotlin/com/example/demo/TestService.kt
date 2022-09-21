package com.example.demo

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class TestService(
    private val testRepository: TestRepository,
    private val subTestRepository: SubTestRepository
) {

    suspend fun createTest(): TestResponse {
        val test = Test(
            "테스트"
        )

        val savedTest = testRepository.save(test)

        for (i in 1..5) {
            val subTest = SubTest(
                subTest = "테스트2 - $i",
                id = savedTest.id
            )

            subTestRepository.save(subTest)
        }

        return TestResponse.of(savedTest)
    }

    suspend fun getTests(): List<Test> {
        return testRepository.findAll().toList()
    }

    suspend fun getTest(id: Long): Test {
        return testRepository.findByIdWithSubTest(id).awaitFirst() ?: kotlin.run { throw RuntimeException() }
    }

    suspend fun deleteTest(id: Long) {
        testRepository.deleteById(id)
    }

    suspend fun updateTest(id: Long): Test {
        val test = Test(
            test = "테스트2",
            id = id
        )

        return testRepository.save(test)
    }
}