package com.example.demo

import javax.persistence.*


@Entity
@Table(name="test")
class Test(
    @Column(name = "test")
    var test: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)