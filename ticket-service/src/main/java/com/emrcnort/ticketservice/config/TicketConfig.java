package com.emrcnort.ticketservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.emrcnort")
@EnableElasticsearchRepositories
@ComponentScan("com.emrcnort")
public class TicketConfig {
}
