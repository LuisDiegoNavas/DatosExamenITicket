/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.datos.controller;

import com.examen.datos.entity.Artista;
import com.examen.datos.entity.Evento;
import com.examen.datos.services.IArtistaService;
import com.examen.datos.services.IEventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author BairesDev
 */

@Controller
public class EventoController {
    @Autowired
    private IEventoService eventoService;
    
    @Autowired
    private IArtistaService artistaService;
    
    @GetMapping("/eventos")
    public String index (Model model) {
        List<Evento> listaEventos = eventoService.getAllEventos();
        model.addAttribute("titulo", "Proximos Eventos 2022");
        model.addAttribute("eventos", listaEventos);
        return "eventos";
    }
    
    @GetMapping("/eventosN")
    public String crearEvento (Model model) {
        List<Artista> listaArtista = artistaService.getAllArtista();
        model.addAttribute("evento", new Evento());
        model.addAttribute("artistas", listaArtista);
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarEvento (@ModelAttribute Evento evento) {
        eventoService.saveEvento(evento);
        return "redirect:/eventos";
    }
    
    @GetMapping("/editEvento/{id}")
    public String editEvento (@PathVariable("id") Long idEvento, Model model) {
        Evento evento = eventoService.getEventoById(idEvento);
        List<Artista> listaArtista = artistaService.getAllArtista();
        model.addAttribute("evento", evento);
        model.addAttribute("artistas", listaArtista);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEvento (@PathVariable("id") Long idEvento) {
        eventoService.delete(idEvento);
        return "redirect:/eventos";
    }
}
