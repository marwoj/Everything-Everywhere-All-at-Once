package com.marwoj.eeaao.coroutines

import com.marwoj.eeaao.model.Activity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ActivityRepository : CoroutineCrudRepository<Activity, String>