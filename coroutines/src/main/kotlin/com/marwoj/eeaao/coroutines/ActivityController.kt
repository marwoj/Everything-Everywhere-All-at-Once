package com.marwoj.eeaao.coroutines

import com.marwoj.eeaao.model.Activity
import com.marwoj.eeaao.model.ActivityDetails
import com.marwoj.eeaao.model.AuthorStatistics
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ActivityController(
    private val activityRepository: ActivityRepository,
    private val authorRepository: AuthorRepository,
) {

    @GetMapping("/activities/author/{authorId}")
    suspend fun activitiesByAuthor(@PathVariable authorId: String): Flow<Activity> =
        activityRepository.findAllByAuthorId(authorId)

    @GetMapping("/activities/{activityId}/author")
    suspend fun activityDetails(@PathVariable activityId: String): ActivityDetails {
        val activity = activityRepository.findById(activityId) ?: throw Exception("Activity does not exist")
        val author = authorRepository.findById(activity.authorId) ?: throw Exception("Author does not exist")
        return ActivityDetails(title = activity.title, firstName = author.firstName, lastName = author.lastName)
    }

    @GetMapping("/activities/author/{authorId}/statistics")
    suspend fun authorStatistics(@PathVariable authorId: String): AuthorStatistics = coroutineScope {
        val author = async { authorRepository.findById(authorId) ?: throw Exception("Author does not exist") }
        val activitiesCount = async { activityRepository.countAllByAuthorId(authorId) }

        AuthorStatistics(
            firstName = author.await().firstName,
            lastName = author.await().lastName,
            activitiesCount = activitiesCount.await()
        )
    }
}
