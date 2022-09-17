package com.example.demo

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TestRepository : CoroutineCrudRepository<Test, Long> {
}