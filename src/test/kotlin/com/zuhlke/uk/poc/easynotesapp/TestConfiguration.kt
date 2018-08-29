package com.zuhlke.uk.poc.easynotesapp

import com.github.fakemongo.Fongo
import com.mongodb.MongoClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.config.AbstractMongoConfiguration

@Configuration
@Profile("test", "pactVerify")
class TestConfiguration : AbstractMongoConfiguration() {
    @Autowired
    lateinit var env: Environment

    override fun getDatabaseName() = returnDatabaseName();

    fun returnDatabaseName() : String {
        val dbname = env.getProperty("mongo.db.name", "test")
        logger.info("Getting in-memory database name: $dbname")
        return dbname
    }

    override fun mongoClient(): MongoClient {
        logger.info("Instantiating Fongo with name $databaseName.")
        return Fongo(databaseName).mongo
    }

    companion object {
        val logger: Logger =
                LoggerFactory.getLogger(TestConfiguration::class.java)
    }
}