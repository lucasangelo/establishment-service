package br.com.lucasangelo.establishmentservice.service;

import br.com.lucasangelo.establishmentservice.model.Establishment;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EstablishmentService {

    public Establishment getEstablishment() {
        Establishment establishment = new Establishment();
        establishment.setId(1);
        establishment.setName("Test");

        return establishment;
    }

//    public Establishment createEstablishment() {
//        Logger.
//    }
}
