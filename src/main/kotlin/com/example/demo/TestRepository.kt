package com.example.demo

import io.smallrye.mutiny.Uni
import org.hibernate.reactive.mutiny.Mutiny.Session
import org.hibernate.reactive.mutiny.Mutiny.SessionFactory
import org.springframework.stereotype.Repository
import java.util.function.Function
import java.util.function.Supplier
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaDelete
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

@Repository
class TestRepository(
    private val sessionFactory: SessionFactory
) {

    fun save(test: Test): Uni<Test> {

        return if (test.id == null) {
            sessionFactory.withTransaction { session ->
                session.persist(test)
                    .replaceWith(test)
            }
        } else {
            sessionFactory.withTransaction { session: Session ->
                session.merge(test)
            }
        }
    }

    fun findAll(): Uni<MutableList<Test>>? {
        val cb: CriteriaBuilder = sessionFactory.criteriaBuilder;
        val query: CriteriaQuery<Test> = cb.createQuery(Test::class.java)

        query.from(Test::class.java)

        return sessionFactory.withSession { session ->
            session.createQuery(query).resultList
        }
    }

    fun findById(id: Long): Uni<Test> {
        return sessionFactory.withSession { session ->
            session.find(Test::class.java, id)
                .onItem()
                .ifNull()
                .failWith { RuntimeException() }
        }
    }

    fun deleteById(id: Long): Uni<Int>? {
        val cb: CriteriaBuilder = sessionFactory.criteriaBuilder;
        val query: CriteriaDelete<Test> = cb.createCriteriaDelete(Test::class.java)
        val from: Root<Test> = query.from(Test::class.java)

        query.where(cb.equal(from.get<Long>(Test::id.name), id))

        return sessionFactory.withTransaction { session ->
            session.createQuery(query).executeUpdate()
        }
    }
}