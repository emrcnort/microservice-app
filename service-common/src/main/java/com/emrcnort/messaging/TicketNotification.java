package com.emrcnort.messaging;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TicketNotification {
    private String ticketId;
    private String accountId;
    private String ticketDescription;
}
