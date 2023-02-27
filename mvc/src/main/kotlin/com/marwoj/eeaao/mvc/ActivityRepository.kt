package com.marwoj.eeaao.mvc

import com.marwoj.eeaao.model.Activity
import org.springframework.data.mongodb.repository.MongoRepository

interface ActivityRepository : MongoRepository<Activity, String> {
    fun findAllByAuthorId(authorId: String): List<Activity>
    fun countActivitiesByAuthorId(authorId: String): Long
}