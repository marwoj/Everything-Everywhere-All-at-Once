package com.marwoj.eeaao.loom

import com.marwoj.eeaao.model.Activity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ActivityController(
    private val activityRepository: ActivityRepository,
) {
    @GetMapping("/activities")
    fun activities(): List<Activity> = activityRepository.findAll()
}