package com.example.demo

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "sub_test")
class SubTest(
    @Column("sub_test")
    var subTest: String,

    @Column("id")
    var id: Long? = null,

    @Id
    @Column("sub_test_id")
    var subTestId: Long? = null
)