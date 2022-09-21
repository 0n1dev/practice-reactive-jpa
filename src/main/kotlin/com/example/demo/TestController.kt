package com.example.demo

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/tests")
class TestController(
    private val testService: TestService
) {

    @GetMapping
    suspend fun getTests(): List<Test> {
        return testService.getTests()
    }

    @GetMapping("/{id}")
    suspend fun getTest(@PathVariable id: Long): Test {
        return testService.getTest(id)
    }

    @PostMapping
    suspend fun createTest(): TestResponse {
        return testService.createTest()
    }

    @PutMapping("/{id}")
    suspend fun updateTest(@PathVariable id: Long) {
        testService.updateTest(id)
    }

    @DeleteMapping("/{id}")
    suspend fun deleteTest(@PathVariable id: Long) {
        testService.deleteTest(id)
    }
}