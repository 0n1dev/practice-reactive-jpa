package com.example.demo

import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
class CustomTestRepositoryImpl(
    private val databaseClient: DatabaseClient
) : CustomTestRepository {

    override fun findByIdWithSubTest(id: Long): Flux<Test> {
        val query = "SELECT t.id, st.sub_test, st.sub_test_id, t.test from test t LEFT JOIN sub_test st ON t.id = st.id WHERE t.id = " + id

        return databaseClient.sql(query)
            .fetch()
            .all()
            .bufferUntilChanged {
                it.get("id")
            }
            .map { rows ->
                val test = Test(
                    id = rows.get(0).get("id").toString().toLong(),
                    test = rows.get(0).get("test").toString(),
                )

                rows.stream()
                    .map { row ->
                        SubTest(
                            subTestId = row.get("sub_test_id").toString().toLong(),
                            subTest = row.get("sub_test").toString()
                        )
                    }
                    .forEach { test.addList(it) }

                test
            }
    }
}