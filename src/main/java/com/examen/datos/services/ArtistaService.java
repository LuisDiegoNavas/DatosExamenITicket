/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.datos.services;

import com.examen.datos.entity.Artista;
import com.examen.datos.repository.ArtistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BairesDev
 */
@Service
public class ArtistaService implements IArtistaService{
    
    @Autowired
    private ArtistaRepository artistaRepository;
    
    @Override
    public List<Artista> getAllArtista() {
      return (List<Artista>)artistaRepository.findAll();  
    }
}
