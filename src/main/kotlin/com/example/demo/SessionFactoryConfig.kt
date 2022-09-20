package com.example.demo

import org.hibernate.reactive.mutiny.Mutiny.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.Persistence

@Configuration
class SessionFactoryConfig {

    companion object {
        private const val PERSISTENCE_UNIT_NAME = "app";
    }

    @Bean
    fun sessionFactory(): SessionFactory {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
            .unwrap(SessionFactory::class.java)
    }
}