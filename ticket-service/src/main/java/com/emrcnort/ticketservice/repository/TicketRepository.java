package com.emrcnort.ticketservice.repository;

import com.emrcnort.ticketservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository  extends JpaRepository<Ticket,String> {
}
