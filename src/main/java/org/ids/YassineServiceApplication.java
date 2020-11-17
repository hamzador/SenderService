package org.ids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories
@SpringBootApplication
public class YassineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(YassineServiceApplication.class, args);
	}

}
