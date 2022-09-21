package com.example.demo

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface SubTestRepository : CoroutineCrudRepository<SubTest, Long> {
}