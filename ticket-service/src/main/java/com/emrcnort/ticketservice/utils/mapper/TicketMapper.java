package com.emrcnort.ticketservice.utils.mapper;

import com.emrcnort.ticketservice.dto.TicketDto;
import com.emrcnort.ticketservice.entity.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketDto convertTicketToTicketDto(Ticket ticket);

    Ticket convertTicketDtoToTicket(TicketDto ticketDto);

}
