package com.elcom.flux.services;

import com.elcom.flux.entities.Cycle;
import com.elcom.flux.entities.Responsable;
import com.elcom.flux.repositories.*;
import com.elcom.flux.responses.ChartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChartService {
    @Autowired
    private ODPRepository odpRepository;
    @Autowired
    private CycleRepository cycleRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ResponsableRepository responsableRepository;
    @Autowired
    private OperateurRepository operateurRepository;
    public ChartResponse odbByEtat() {
        ChartResponse chartResponse = new ChartResponse();
        List<String> labels = new ArrayList<>();
        labels.add("En attente");
        labels.add("Production");
        List<Long> values = new ArrayList<>();
        long value1 = odpRepository.countByEtat("En attente");
        long value2 = odpRepository.countByEtat("Production");
        values.add(value1);
        values.add(value2);

        chartResponse.setLabels(labels);
        chartResponse.setValues(values);
        return chartResponse;
    }




    public ChartResponse articleByCycle() {
        ChartResponse chartResponse = new ChartResponse();
        List<Cycle> cycles = cycleRepository.findAll();
        List<String> labels = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for(Cycle cycle: cycles) {
            labels.add(cycle.getNom());
            long value = articleRepository.countByCycle(cycle);
            values.add(value);
        }





        chartResponse.setLabels(labels);
        chartResponse.setValues(values);
        return chartResponse;
    }


    public ChartResponse operateurByResponsable() {
        ChartResponse chartResponse = new ChartResponse();
        List<Responsable> cycles = responsableRepository.findAll();
        List<String> labels = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        List<Long> values2 = new ArrayList<>();
        for(Responsable responsable: cycles) {
            labels.add(responsable.getNom() +" " + responsable.getPrenom());
            long value = operateurRepository.countByResponsableAndEnabled(responsable, true);
            long value2 = operateurRepository.countByResponsableAndEnabled(responsable, false);
            values.add(value);
            values2.add(value2);
        }





        chartResponse.setLabels(labels);
        chartResponse.setValues(values);
        chartResponse.setValues2(values2);
        return chartResponse;


    }
}
