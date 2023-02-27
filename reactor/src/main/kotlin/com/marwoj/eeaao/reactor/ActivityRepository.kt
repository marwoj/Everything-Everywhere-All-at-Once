package com.marwoj.eeaao.reactor

import com.marwoj.eeaao.model.Activity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ActivityRepository : ReactiveMongoRepository<Activity, String> {
    fun findAllByAuthorId(authorId: String): Flux<Activity>
    fun countAllByAuthorId(authorId: String): Mono<Long>
}