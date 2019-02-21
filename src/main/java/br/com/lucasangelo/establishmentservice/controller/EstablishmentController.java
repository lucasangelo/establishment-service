package br.com.lucasangelo.establishmentservice.controller;
import br.com.lucasangelo.establishmentservice.model.Establishment;
import br.com.lucasangelo.establishmentservice.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/establishment")
public class EstablishmentController {
    private final EstablishmentService service;

    @Autowired
    public EstablishmentController(EstablishmentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createEstablishment(@RequestBody Establishment establishment) {
        final Establishment newEstablishment = establishment;
        final URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{establishmentId}").
                buildAndExpand(newEstablishment.getId()).toUri();
        return ResponseEntity.created(uri).body(newEstablishment);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{establishmentId}")
    public ResponseEntity getEstablishment(@PathVariable Integer establishmentId) {
        Establishment establishment = this.service.getEstablishment();
        return ResponseEntity.ok(establishment);
    }
}
