package com.marwoj.eeaao.dbsetup

import com.marwoj.eeaao.model.Activity
import com.mongodb.MongoClientSettings.getDefaultCodecRegistry
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Indexes
import org.bson.codecs.configuration.CodecProvider
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider


fun main() {
    val uri = "mongodb://localhost:27017"
    val pojoCodecProvider: CodecProvider = PojoCodecProvider.builder().automatic(true).build()
    val pojoCodecRegistry: CodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider))

    val mongoClient = MongoClients.create(uri)

    val database: MongoDatabase = mongoClient.getDatabase("eeaao").withCodecRegistry(pojoCodecRegistry)
    val collection: MongoCollection<Activity> = database.getCollection("activity", Activity::class.java)

    collection.insertOne(Activity(authorId = "123", reporterId = "123"))

    collection.createIndex(Indexes.ascending("authorId"))
}