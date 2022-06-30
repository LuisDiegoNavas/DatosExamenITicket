/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.datos.services;

import com.examen.datos.entity.Evento;
import java.util.List;

/**
 *
 * @author BairesDev
 */

public interface IEventoService {
    
     public List <Evento> getAllEventos();
     public Evento getEventoById (long Id);
     public void saveEvento (Evento evento);
     public void delete (long id);
}
