package com.marwoj.eeaao.mvc

import com.marwoj.eeaao.model.Activity
import org.springframework.data.mongodb.repository.MongoRepository

interface ActivityRepository : MongoRepository<Activity, String>