package com.marwoj.eeaao.model

data class Activity(
    val title: String,
    val authorId: String,
    val id: String? = null,
)

data class Author(
    val firstName: String,
    val lastName: String,
    val id: String? = null,
)

data class AuthorStatistics(
    val firstName: String,
    val lastName: String,
    val activitiesCount: Long,
)

data class ActivityDetails(
    val title: String,
    val firstName: String,
    val lastName: String,
)
