package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/test")
class TestController(
    private val testService: TestService
) {

    @GetMapping
    fun test(): Mono<Test> {
        return testService.test()
    }
}