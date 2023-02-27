package com.marwoj.eeaao.dbsetup

import com.marwoj.eeaao.model.Activity
import com.marwoj.eeaao.model.Author
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.codecs.configuration.CodecProvider
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider


object MongoConfig {
    private const val uri = "mongodb://localhost:27017"

    val activities: MongoCollection<Activity>
    val authors: MongoCollection<Author>

    init {
        val pojoCodecProvider: CodecProvider = PojoCodecProvider.builder().automatic(true).build()
        val pojoCodecRegistry: CodecRegistry =
            CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(pojoCodecProvider)
            )

        val mongoClient = MongoClients.create(uri)
        mongoClient.getDatabase("eeaao").drop()
        val database: MongoDatabase = mongoClient.getDatabase("eeaao")
            .withCodecRegistry(pojoCodecRegistry)
        database.createCollections()

        activities = database.getCollection("activity", Activity::class.java)
        authors = database.getCollection("author", Author::class.java)
//        activities.createIndex(Indexes.ascending("authorId"))
    }

    private fun MongoDatabase.createCollections() {
        val existingCollections = listCollectionNames()
        if (!existingCollections.contains("activity")) {
            createCollection("activity")
        }
        if (!existingCollections.contains("author")) {
            createCollection("author")
        }
    }
}
