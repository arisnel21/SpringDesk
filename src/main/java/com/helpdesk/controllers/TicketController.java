package com.helpdesk.controllers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.helpdesk.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import com.helpdesk.models.Ticket;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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

    @GetMapping("/tickets/{id}") // busca por un ticket en especifico
    public Optional<Ticket> buscarPorId(@PathVariable Long id){  //optional previene el NullPointerException (indica que el resultado existe o no)
        return ticketService.buscarPorId(id);
    }

    @PutMapping("/tickets/{id}")
    public Ticket actualizarTicket(@PathVariable Long id,@RequestBody Ticket ticketActualizado){
        return ticketService.actualizarTicket(id,ticketActualizado);
    }
    @DeleteMapping("/tickets/{id}")
    public void  eliminarTicket(@PathVariable Long id){
        ticketService.eliminarTicket(id);
    }


    @PostMapping("/tickets")// endpoint para crear
    public Ticket crearTicket(@RequestBody Ticket ticket){// este es el endpoint para crear un nuevo ticket
        return ticketService.guardarTicket(ticket);
    }
}
