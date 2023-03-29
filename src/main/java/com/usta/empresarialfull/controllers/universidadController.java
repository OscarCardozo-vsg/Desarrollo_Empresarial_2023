package com.usta.empresarialfull.controllers;

import com.usta.empresarialfull.entities.universidadEntity;
import com.usta.empresarialfull.models.services.IuniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class universidadController {
    @Autowired
    private IuniversidadService IuniversidadService;

    @GetMapping("listarUniversidades")
    public String listarUniversidades(Model model) {
        model.addAttribute("universidades", IuniversidadService.findAll());
        model.addAttribute("titulos", "Listado Universidades");
        return "listarUniversidades";
    }

    @GetMapping("crearUniversidad")
    public String crearUniversidad(Model model) {
        model.addAttribute("titulo", "Crear Universidades");
        model.addAttribute("universidad", new universidadEntity());
        return "crearUniversidad";
    }

    @PostMapping(value = "crearUniversidad")
    public String guardarUniversidad(@Valid universidadEntity universidad, BindingResult result, SessionStatus status){
        if (result.hasErrors()){
            return "error500";
        }
        universidad.setEstado(true);
        IuniversidadService.save(universidad);
        status.setComplete();
        return "redirect:/listarUniversidades";
    }
    @RequestMapping(value = "/eliminarUniversidad/{id}") //nuevo
    public String eliminarById(@PathVariable(value = "id") Long id){
        if(id>0){
            IuniversidadService.remove(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarUniversidades";
    }
    @RequestMapping(value = "/cambiarEstadoUniversidad/{id}")
    public String cambiarEstadoUniversidad(@PathVariable(value = "id")Long id){
        if(id>0){
            IuniversidadService.changeState(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarUniversidades";
    }
    @GetMapping("/editarUniversidad/{id}")
    public String mostrarFormularioUniversidad(
            @PathVariable(value="id")Long id, Model model){
        model.addAttribute("titulo","Editar Universidad");
        model.addAttribute("universidadActualizar",IuniversidadService.findOne(id));
        return "editarUniversidad";
    }
    @PostMapping("editarUniversidad/{id}")
    public String actualizarUniversidad(
            @PathVariable(value = "id") Long id,
            @ModelAttribute("universidadActualizar")
            universidadEntity universidad
    ){
        universidadEntity universidadExistente = IuniversidadService.findOne(id);
        universidadExistente.setEstado(true);
        universidadExistente.setNit(universidad.getNit());
        universidadExistente.setNombre(universidad.getNombre());
        universidadExistente.setFechaFundacion(universidad.getFechaFundacion());
        universidadExistente.setDireccion(universidad.getDireccion());
        universidadExistente.setTelefono(universidad.getTelefono());

        IuniversidadService.updateUniversidad(universidadExistente);
        return "redirect:/listarUniversidades";
    }


}