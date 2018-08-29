package com.zuhlke.uk.poc.easynotesapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

//@TypeAlias("notes") -- does not work!
@Document(collection = "notes")
data class Note (@Id val _id: String?,
                val title: String,
                val content: String,
                val createdAt: String?,
                val updatedAt: String?,
                val __v: Int?)
