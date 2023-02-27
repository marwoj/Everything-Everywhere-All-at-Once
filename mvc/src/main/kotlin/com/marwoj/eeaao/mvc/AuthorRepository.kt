package com.marwoj.eeaao.mvc

import com.marwoj.eeaao.model.Author
import org.springframework.data.mongodb.repository.MongoRepository

interface AuthorRepository : MongoRepository<Author, String>