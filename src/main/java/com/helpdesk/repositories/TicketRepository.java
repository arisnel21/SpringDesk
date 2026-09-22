package com.helpdesk.repositories;

import com.helpdesk.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket,Long> {

}
