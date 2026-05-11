package com.mars.admin.controller;

import com.mars.admin.model.Jugador;
import com.mars.admin.repository.EstiloJuegoRepository;
import com.mars.admin.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/scouting")
public class ScoutingController {

    @Autowired
    private EstiloJuegoRepository estiloJuegoRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @GetMapping("/buscador")
    public String buscador(Model model) {
        model.addAttribute("estilos", estiloJuegoRepository.findAll());
        return "scouting/buscador";
    }

    @GetMapping("/api/jugadores/{estiloId}")
    @ResponseBody
    public List<Jugador> getJugadoresPorEstilo(@PathVariable Long estiloId) {
        return jugadorRepository.findByEstiloJuegoId(estiloId);
    }
}
