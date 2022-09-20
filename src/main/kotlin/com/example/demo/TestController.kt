package com.example.demo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tests")
class TestController(
    private val testService: TestService
) {

    @GetMapping
    suspend fun getTests(): MutableList<Test>? {
        return testService.getTests()
    }

    @GetMapping("/{id}")
    suspend fun getTest(@PathVariable id: Long): Test {
        return testService.getTest(id)
    }

    @PostMapping
    suspend fun createTest(): Test {
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