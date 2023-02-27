package com.marwoj.eeaao.coroutines

import com.marwoj.eeaao.model.Author
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface AuthorRepository : CoroutineCrudRepository<Author, String>