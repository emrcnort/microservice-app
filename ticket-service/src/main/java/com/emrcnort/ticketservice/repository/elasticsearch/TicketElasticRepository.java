package com.emrcnort.ticketservice.repository.elasticsearch;

import com.emrcnort.ticketservice.entity.elasticsearch.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel,String> {
}
