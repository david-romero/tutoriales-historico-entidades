package com.david.tutoriales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
public class DbConfigHistoricos extends AbstractMongoConfiguration {


	@Override
	protected String getDatabaseName() {
		return "historicos";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoClient client = new MongoClient("localhost");
		return client;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "historicos");
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.david.tutoriales.model";
	}
}