package com.helpdesk.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @Enumerated(EnumType.STRING)/*se guardara en la BD como texto*/
    private EstadoTicket estado = EstadoTicket.ABIERTO;

    @Enumerated(EnumType.STRING)/*se guardara en la BD como texto*/
    private PrioridadTicket Prioridad = PrioridadTicket.MEDIA;

    @ManyToOne
    @JoinColumn(name = "tecnico_id",nullable = true)//se le dice a hibernate creame la relacion entre ticket y tecnico y que se llame tecnico_id
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;

    private LocalDateTime fechaCreacion;

    @PrePersist
    public void asignarFechaCreacion(){

        fechaCreacion = LocalDateTime.now();
    }


}
