package com.marwoj.eeaao.coroutines

import com.marwoj.eeaao.model.Activity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ActivityRepository : CoroutineCrudRepository<Activity, String> {
    suspend fun findAllByAuthorId(authorId: String): Flow<Activity>
    suspend fun countAllByAuthorId(authorId: String): Long
}