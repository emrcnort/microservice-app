package com.emrcnort.ticketservice.service;

import com.emrcnort.client.AccountServiceClient;
import com.emrcnort.contract.AccountDto;
import com.emrcnort.ticketservice.dto.TicketDto;
import com.emrcnort.ticketservice.entity.Ticket;
import com.emrcnort.ticketservice.entity.elasticsearch.TicketModel;
import com.emrcnort.ticketservice.entity.enums.PriorityType;
import com.emrcnort.ticketservice.entity.enums.TicketStatus;
import com.emrcnort.ticketservice.repository.TicketRepository;
import com.emrcnort.ticketservice.repository.elasticsearch.TicketElasticRepository;
import com.emrcnort.ticketservice.utils.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketElasticRepository ticketElasticRepository;
    private final AccountServiceClient accountServiceClient;
    private final TicketMapper mapper;

    @Transactional
    public TicketDto save(TicketDto ticketDto){
       Ticket ticket = new Ticket();

        ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAssignee());

       if(ticketDto.getDescription() == null){
           throw new IllegalArgumentException("Description bos olamaz");
       }
        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());
        ticket = ticketRepository.save(ticket);

       TicketModel ticketModel = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .assignee(accountDtoResponseEntity.getBody().getNameSurname())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();
       ticketElasticRepository.save(ticketModel);

       ticketDto.setId(ticket.getId());
       return ticketDto;

    };

    public TicketDto update(String id, TicketDto ticketDto){
        return null;
    };

    public TicketDto delete(TicketDto ticketDto){
        return null;
    };

    public TicketDto getById(String ticketId){
        return null;
    };

    public Page<TicketDto> getPagination(Pageable pageable){
        return null;
    };

}
