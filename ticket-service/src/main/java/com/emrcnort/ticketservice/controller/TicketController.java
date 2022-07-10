package com.emrcnort.ticketservice.controller;

import com.emrcnort.ticketservice.dto.TicketDto;
import com.emrcnort.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable String id){
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<Page<TicketDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(ticketService.getPagination(pageable));
    }

    @PostMapping()
    public ResponseEntity<TicketDto> create(@RequestBody TicketDto ticketDto){
        return ResponseEntity.ok(ticketService.save(ticketDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> update(@PathVariable String id, @RequestBody TicketDto ticketDto){
        return ResponseEntity.ok(ticketService.update(id, ticketDto));
    }


}
