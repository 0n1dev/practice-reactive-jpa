package com.example.demo

import reactor.core.publisher.Flux

interface CustomTestRepository {

    fun findByIdWithSubTest(id: Long): Flux<Test>
}