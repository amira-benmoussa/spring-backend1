package com.elcom.flux.controllers;

import com.elcom.flux.repositories.CycleRepository;
import com.elcom.flux.responses.ChartResponse;
import com.elcom.flux.services.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private ChartService chartService;




    @GetMapping("/etat-odp")
    public ChartResponse odpByEtat() {
        return  chartService.odbByEtat();
    }

    @GetMapping("/article-cycle")
    public ChartResponse articleByCycle() {
        return  chartService.articleByCycle();
    }
    @GetMapping("/operateur-responsable")
    public ChartResponse operateurByResponsable() {
        return  chartService.operateurByResponsable();
    }
}
