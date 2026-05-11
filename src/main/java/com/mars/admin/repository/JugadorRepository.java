package com.mars.admin.repository;

import com.mars.admin.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    List<Jugador> findByEstiloJuegoId(Long estiloJuegoId);
}
