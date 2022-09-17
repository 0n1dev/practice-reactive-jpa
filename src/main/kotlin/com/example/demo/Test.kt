package com.example.demo

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "test")
class Test(
    @Column("test")
    var test: String,

    @Id
    @Column("id")
    var id: Long? = null
)