package com.helpdesk.service;

import com.helpdesk.models.Ticket;
import org.springframework.stereotype.Service;
import com.helpdesk.repositories.TicketRepository;
import java.util.List;
import java.util.Optional;

@Service // le estamos diciendo a spring "esta clase forma parte de la logica de negocio de mi aplicacion administralo
public class TicketService {

    private final TicketRepository ticketRepository;// en la interfaz encargada de hacer las consultas (sobre la tabla de tickets

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Ticket guardarTicket(Ticket ticket){ //created

        return ticketRepository.save(ticket);
    }

    public List<Ticket> listarTickets() { //read All
        return ticketRepository.findAll();
    }
    public Optional<Ticket> buscarPorId(Long id) { //Read One
        return ticketRepository.findById(id);
    }

    public void eliminarTicket(Long id) { //si existe -> obtenemos el ticket / si no existe -> lanza una excepcion
        Optional<Ticket> resultado = ticketRepository.findById(id);// busca el ticket

        Ticket ticket = resultado.orElseThrow();//comprueba que exista el ticket si no lanza un error

        ticketRepository.delete(ticket);// si existe lo elimina
    }

    public Ticket actualizarTicket(Long id, Ticket ticketActualizado) {//metodo para actualizar el ticket
        Optional<Ticket> resultado = ticketRepository.findById(id);

            Ticket ticket = resultado.orElseThrow();

            ticket.setTitulo(ticketActualizado.getTitulo());
            ticket.setDescripcion(ticketActualizado.getDescripcion());
            ticket.setPrioridad(ticketActualizado.getPrioridad());
            ticket.setEstado(ticketActualizado.getEstado());
            return ticketRepository.save(ticket);
    }
}
