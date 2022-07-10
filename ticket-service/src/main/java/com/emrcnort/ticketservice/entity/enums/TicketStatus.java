package com.emrcnort.ticketservice.entity.enums;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Acik"), IN_PROGRESS("Calisiliyor"), RESOLVED ("Cozuldu"), CLOSED("Kapandi");

    private String label;

    TicketStatus(String label){
        this.label = label;
    }
}
