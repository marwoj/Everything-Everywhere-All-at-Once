package com.marwoj.eeaao.reactor

import com.marwoj.eeaao.model.Activity
import com.marwoj.eeaao.model.ActivityDetails
import com.marwoj.eeaao.model.AuthorStatistics
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.util.function.component1
import reactor.kotlin.core.util.function.component2

@RestController
class ActivityController(
    private val activityRepository: ActivityRepository,
    private val authorRepository: AuthorRepository,
) {
    @GetMapping("/activities/author/{authorId}")
    fun activitiesByAuthor(@PathVariable authorId: String): Flux<Activity> =
        activityRepository.findAllByAuthorId(authorId)

    @GetMapping("/activities/{activityId}/author")
    fun activityDetails(@PathVariable activityId: String): Mono<ActivityDetails> =
        activityRepository.findById(activityId)
            .switchIfEmpty { Mono.error(Exception("Activity does not exist")) }
            .flatMap { activity ->
                authorRepository.findById(activity.authorId)
                    .switchIfEmpty { Mono.error(Exception("Author does not exist")) }
                    .map { author ->
                        ActivityDetails(
                            title = activity.title, firstName = author.firstName, lastName = author.lastName
                        )
                    }
            }

    @GetMapping("/activities/author/{authorId}/statistics")
    fun authorStatistics(@PathVariable authorId: String): Mono<AuthorStatistics> =
        Mono.zip(
            authorRepository.findById(authorId).switchIfEmpty(Mono.error(Exception("Author does not exist"))),
            activityRepository.countAllByAuthorId(authorId),
        ).map { (author, activitiesCount) ->
            AuthorStatistics(
                firstName = author.firstName,
                lastName = author.lastName,
                activitiesCount = activitiesCount
            )
        }
}
