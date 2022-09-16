package com.example.demo

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface TestRepository : ReactiveCrudRepository<Test, Long> {
}