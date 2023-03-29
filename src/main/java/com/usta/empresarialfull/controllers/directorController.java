package com.usta.empresarialfull.controllers;

import com.usta.empresarialfull.entities.directorEntity;
import com.usta.empresarialfull.models.services.IdirectorService;
import com.usta.empresarialfull.models.services.IuniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class directorController {
    @Autowired
    private IdirectorService IdirectorService;
    @Autowired
    private IuniversidadService IuniversidadService;

    @GetMapping("listarDirectores")
    public String listarDirector(Model model){
        model.addAttribute("universidades",IdirectorService.findAll());
        model.addAttribute("titulos","Listado Directores");
        return "listarDirectores";
    }

    @GetMapping("/crearDirector")
    public String FormularioDirector(Model model){
        model.addAttribute("titulo","Listado de Directores");
        model.addAttribute("directores", new directorEntity());
        model.addAttribute("uni", IuniversidadService.selectOneUni());
        return "crearDirector";
    }
}
