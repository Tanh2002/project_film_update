package com.project_movie.services;

import com.project_movie.dtos.TicketDTO;
import com.project_movie.entities.Ticket;

import java.util.List;

public interface ITicketService {
    List<TicketDTO> getTicketsByUserId(Integer userId);

    List<Ticket> getAllTickets();

    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(int id, Ticket updatedTicket);

    void deleteTicket(int id);
}
