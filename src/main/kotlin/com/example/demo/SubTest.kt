package com.example.demo

import javax.persistence.*

@Entity
@Table(name="sub_test")
class SubTest(
    @Column(name = "sub_test")
    var subTest: String,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    var test: Test? = null,

    @Id
    @Column(name = "sub_test_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var subTestId: Long? = null
)