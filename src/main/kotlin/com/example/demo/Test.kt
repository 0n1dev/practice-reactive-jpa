package com.example.demo

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "test")
class Test(
    @Column("test")
    var test: String,

    @Transient
    var list: MutableList<SubTest> = mutableListOf(),

    @Id
    @Column("id")
    var id: Long? = null
) {

    fun addList(subTest: SubTest) {
        list.add(subTest)
    }
}