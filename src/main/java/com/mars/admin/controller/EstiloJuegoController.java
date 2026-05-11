package com.mars.admin.controller;

import com.mars.admin.model.EstiloJuego;
import com.mars.admin.repository.EstiloJuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estilos")
public class EstiloJuegoController {

    @Autowired
    private EstiloJuegoRepository estiloJuegoRepository;

    @GetMapping
    public String listarEstilos(Model model) {
        model.addAttribute("estilos", estiloJuegoRepository.findAll());
        return "estilo/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("estilo", new EstiloJuego());
        return "estilo/form";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        EstiloJuego estilo = estiloJuegoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de estilo inválido: " + id));
        model.addAttribute("estilo", estilo);
        return "estilo/form";
    }

    @PostMapping("/guardar")
    public String guardarEstilo(@ModelAttribute EstiloJuego estilo) {
        estiloJuegoRepository.save(estilo);
        return "redirect:/estilos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstilo(@PathVariable Long id) {
        estiloJuegoRepository.deleteById(id);
        return "redirect:/estilos";
    }
}
