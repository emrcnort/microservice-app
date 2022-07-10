package com.emrcnort.ticketservice.entity.enums;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Acil"), LOW("Dusuk Oncelik"), HIGH("Yuksek Oncelik");

    private String label;

    PriorityType(String label){
        this.label = label;
    }
}
