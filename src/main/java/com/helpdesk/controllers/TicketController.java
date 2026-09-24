package com.helpdesk.controllers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.helpdesk.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import com.helpdesk.models.Ticket;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

@RestController //Spring esta clase va a recibir peticiones HTTP de los clientes y respundera mediante una API REST
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;

    }
    @GetMapping("/tickets")// "Cuando llegue una peticion HTTP de tipo Get a /tickets, ejecuta este metodo"
    public List<Ticket> listarTickets() {// endpoint para leer
        return ticketService.listarTickets();
    }

    @PostMapping("/tickets")// endpoint para crear
    public Ticket crearTicket(@RequestBody Ticket ticket){// este es el endpoint para crear un nuevo ticket
        return ticketService.guardarTicket(ticket);
    }
}
