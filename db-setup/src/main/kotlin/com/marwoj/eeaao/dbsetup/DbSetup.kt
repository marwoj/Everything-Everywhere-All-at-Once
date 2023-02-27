package com.marwoj.eeaao.dbsetup

import com.marwoj.eeaao.dbsetup.ActivityIdGenerator.generateActivityIds
import com.marwoj.eeaao.dbsetup.MongoConfig.activities
import com.marwoj.eeaao.dbsetup.MongoConfig.authors
import com.marwoj.eeaao.dbsetup.Simulation.activitiesPerAuthor
import com.marwoj.eeaao.dbsetup.Simulation.authorsNumber
import com.marwoj.eeaao.model.Activity
import com.marwoj.eeaao.model.Author
import org.bson.Document


object Simulation {
    const val authorsNumber = 20_000 // TODO update if required
    const val activitiesPerAuthor = 5  // TODO update if required
}


fun main() {
    activities.deleteMany(Document())
    authors.deleteMany(Document())

    (1..authorsNumber)
        .map { authorId -> Author(id = authorId.toString(), firstName = "Jane-$authorId", lastName = "Doe-$authorId") }
        .let { authors.insertMany(it) }


    generateActivityIds(authorsNumber = authorsNumber, activitiesPerAuthor = activitiesPerAuthor)
        .mapIndexed { index, ids ->
            Activity(
                id = index.toString(), authorId = ids.authorId,
                title = "Activity: $index, Author: ${ids.authorId}, Author activity no.: ${ids.authorActivityNo}",
            )
        }
        .chunked(50_000)
        .forEach { activitiesToAdd ->
            println("Insert data chunk to database")
            activities.insertMany(activitiesToAdd)
        }

}


