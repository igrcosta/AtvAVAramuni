package com.atvAV.demo.Controller;

import com.atvAV.demo.service.CandidatosTseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CandidatosTseController {

    private final CandidatosTseService candidatosTseService;

    public CandidatosTseController(CandidatosTseService candidatosTseService) {
        this.candidatosTseService = candidatosTseService;
    }

    @GetMapping({"/", "/candidatos"})
    public String listar(
            @RequestParam(required = false) String cargo,
            @RequestParam(required = false) String partido,
            @RequestParam(required = false) String texto,
            Model model) {
        model.addAttribute("candidatos", candidatosTseService.filtrar(cargo, partido, texto));
        model.addAttribute("cargos", candidatosTseService.listarCargos());
        model.addAttribute("partidos", candidatosTseService.listarPartidos());
        model.addAttribute("cargoSelecionado", cargo == null ? "" : cargo);
        model.addAttribute("partidoSelecionado", partido == null ? "" : partido);
        model.addAttribute("texto", texto == null ? "" : texto);
        return "candidatos";
    }
}
