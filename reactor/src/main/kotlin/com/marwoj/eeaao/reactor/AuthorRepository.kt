package com.marwoj.eeaao.reactor

import com.marwoj.eeaao.model.Author
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface AuthorRepository : ReactiveMongoRepository<Author, String>