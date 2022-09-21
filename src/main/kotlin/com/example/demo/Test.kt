package com.example.demo

import javax.persistence.*


@Entity
@Table(name="test")
class Test(
    @Column(name = "test")
    var test: String,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "test", cascade = [CascadeType.ALL])
    var list: MutableList<SubTest> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {

    fun addList(subTest: SubTest) {
       list.add(subTest)
    }
}