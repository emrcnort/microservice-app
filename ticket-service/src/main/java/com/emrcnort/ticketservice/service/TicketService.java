package com.emrcnort.ticketservice.service;

import com.emrcnort.ticketservice.dto.TicketDto;
import com.emrcnort.ticketservice.repository.TicketRepository;
import com.emrcnort.ticketservice.utils.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository repository;
    private final TicketMapper mapper;

    public TicketDto save(TicketDto ticketDto){
        return null;
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
