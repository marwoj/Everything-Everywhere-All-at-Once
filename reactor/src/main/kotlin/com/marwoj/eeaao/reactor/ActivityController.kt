package com.marwoj.eeaao.reactor

import com.marwoj.eeaao.model.Activity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ActivityController(
    private val activityRepository: ActivityRepository,
) {
    @GetMapping("/activities")
    fun activities(): Flux<Activity> = activityRepository.findAll()
}