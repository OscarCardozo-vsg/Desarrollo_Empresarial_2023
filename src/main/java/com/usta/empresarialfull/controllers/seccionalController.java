package com.usta.empresarialfull.controllers;

import com.usta.empresarialfull.entities.seccionalEntity;
import com.usta.empresarialfull.models.services.IseccionalesService;
import com.usta.empresarialfull.models.services.IuniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class seccionalController {

    @Autowired
    private IseccionalesService IseccionalesService;

    @Autowired
    private IuniversidadService iuniversidadService;

    @GetMapping("/listarSeccionales")
    public String listarSeccionales(Model model){
        model.addAttribute("titulo","Listado de Seccionales");
        model.addAttribute("seccional", IseccionalesService.findAll());
        return "listarSeccionales";
    }

    @GetMapping("/crearSeccional")
    public String formularioCrearSeccional(Model model){
        model.addAttribute("seccional",
                new seccionalEntity());
        model.addAttribute("titulo",
                "Crear Seccional");
        model.addAttribute("universidades",
                iuniversidadService.findAll());
        return "crearSeccional";
    }

    @PostMapping(value = "crearSeccional")
    public String guardarSeccional(@Valid seccionalEntity seccional,
                                   BindingResult result,
                                   SessionStatus status){
        if(result.hasErrors()){
            return "crearSeccional";
        }
        seccional.setEstado(true);
        IseccionalesService.save(seccional);
        status.setComplete();
        return "redirect:/listarSeccionales";
    }

    @RequestMapping(value = "/cambiarEstadoSeccional/{id}")
    public String CambiarEstadoSeccional(@PathVariable("id") Long id){
        if(id>0){
            IseccionalesService.changeState(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarSeccionales";
    }

    @GetMapping("/editarSeccional/{id}")
    public String mostrarFormularioSeccional(
            @PathVariable(value="id")Long id, Model model){
        model.addAttribute("titulo","Editar Seccional");
        model.addAttribute("seccionalActualizar",IseccionalesService.findOne(id));
        return "editarSeccional";
    }
    @PostMapping("editarSeccional/{id}")
    public String actualizarSeccional(
            @PathVariable(value = "id") Long id,
            @ModelAttribute("seccionalActualizar")
            seccionalEntity seccional
    ){
        seccionalEntity seccionalExistente = IseccionalesService.findOne(id);
        seccionalExistente.setEstado(true);
        seccionalExistente.setNombre(seccional.getNombre());
        seccionalExistente.setCantidadFacultades(seccional.getCantidadFacultades());
        seccionalExistente.setIdUniversidad(seccional.getIdUniversidad());

        IseccionalesService.updateSeccional(seccionalExistente);
        return "redirect:/listarSeccionales";
    }

}