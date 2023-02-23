package com.marwoj.eeaao.reactor

import com.marwoj.eeaao.model.Activity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ActivityRepository : ReactiveMongoRepository<Activity, String>