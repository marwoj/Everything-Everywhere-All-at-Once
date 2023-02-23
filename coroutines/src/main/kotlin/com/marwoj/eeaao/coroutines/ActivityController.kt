package com.marwoj.eeaao.coroutines

import com.marwoj.eeaao.model.Activity
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ActivityController(
    private val activityRepository: ActivityRepository,
) {
    @GetMapping("/activities")
    fun activities(): Flow<Activity> = activityRepository.findAll()
}