package com.gestion.eventos.repository;

import com.gestion.eventos.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosRepository extends JpaRepository<Evento, String> {
}
