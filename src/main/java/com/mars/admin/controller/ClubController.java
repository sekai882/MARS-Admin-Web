package com.mars.admin.controller;

import com.mars.admin.model.Club;
import com.mars.admin.repository.ClubRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping
    public String listarClubs(Model model) {
        model.addAttribute("clubs", clubRepository.findAll());
        return "club/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("club", new Club());
        return "club/form";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de club inválido: " + id));
        model.addAttribute("club", club);
        return "club/form";
    }

    @PostMapping("/guardar")
    public String guardarClub(@Valid @ModelAttribute Club club, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "club/form";
        }
        clubRepository.save(club);
        return "redirect:/clubs";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarClub(@PathVariable Long id) {
        clubRepository.deleteById(id);
        return "redirect:/clubs";
    }
}
