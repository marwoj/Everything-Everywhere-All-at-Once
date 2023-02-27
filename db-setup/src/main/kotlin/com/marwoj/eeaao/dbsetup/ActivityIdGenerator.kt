package com.marwoj.eeaao.dbsetup

object ActivityIdGenerator {
    fun generateActivityIds(authorsNumber: Int, activitiesPerAuthor: Int) =
        (1..activitiesPerAuthor)
            .flatMap { authorActivityNo ->
                (1..authorsNumber).map { authorId ->
                    ActivityId(authorId = authorId.toString(), authorActivityNo = authorActivityNo.toString())
                }
            }
}

data class ActivityId(val authorId: String, val authorActivityNo: String)
