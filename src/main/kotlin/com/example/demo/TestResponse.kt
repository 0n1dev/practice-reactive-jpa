package com.example.demo

data class TestResponse(
    val id: Long,
    val test: String,
    val list: MutableList<SubTestResponse>?
) {

    companion object {
        fun of(test: Test): TestResponse {
            val list = test.list?.map {
                SubTestResponse(
                    subTestId = it.subTestId!!,
                    subTest = it.subTest
                )
            }?.toMutableList()

            return TestResponse(
                id = test.id!!,
                test = test.test,
                list = list
            )
        }
    }
}