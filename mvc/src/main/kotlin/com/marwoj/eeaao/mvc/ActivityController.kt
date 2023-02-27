package com.marwoj.eeaao.mvc

import com.marwoj.eeaao.model.Activity
import com.marwoj.eeaao.model.ActivityDetails
import com.marwoj.eeaao.model.Author
import com.marwoj.eeaao.model.AuthorStatistics
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

@RestController
class ActivityController(
    private val activityRepository: ActivityRepository,
    private val authorRepository: AuthorRepository,
) {
    @GetMapping("/activities/author/{authorId}")
    fun activitiesByAuthor(@PathVariable authorId: String): List<Activity> =
        activityRepository.findAllByAuthorId(authorId)

    @GetMapping("/activities/{activityId}/author")
    fun activityDetails(@PathVariable activityId: String): ActivityDetails {
        val activity = activityRepository.findById(activityId).orElseThrow { Exception("Activity does not exist") }
        val author = authorRepository.findById(activity.authorId).orElseThrow { Exception("Author does not exist") }
        return ActivityDetails(title = activity.title, firstName = author.firstName, lastName = author.lastName)
    }

    @GetMapping("/activities/author/{authorId}/statistics")
    fun authorStatistics(@PathVariable authorId: String): AuthorStatistics =
        // try with resources in Kotlin
        Executors.newSingleThreadExecutor().use { executor ->
            val author: Future<Author> =
                executor.submit(Callable {
                    authorRepository.findById(authorId).orElseThrow { Exception("Author does not exist") }
                })
            val activitiesCount: Future<Long> =
                executor.submit(Callable { activityRepository.countActivitiesByAuthorId(authorId) })

            AuthorStatistics(
                firstName = author.get().firstName,
                lastName = author.get().lastName,
                activitiesCount = activitiesCount.get()
            )
        }
}

