package com.elcom.flux.controllers;
import java.util.List;
import com.elcom.flux.entities.Absence;
import com.elcom.flux.requests.AbsenceRequest;
import com.elcom.flux.responses.MessageResponse;
import com.elcom.flux.services.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/absence")
public class AbsenceController {
    @Autowired
    private AbsenceService absenceService;
    @PostMapping
    public MessageResponse upload(@RequestBody List<AbsenceRequest> absenceRequests) {
        return absenceService.save(absenceRequests);
    }
    @GetMapping("/responsable/{id}")
    public List<Absence> findByResponsable(@PathVariable Integer id) {
        return absenceService.findByResponsable(id);
    }
}
