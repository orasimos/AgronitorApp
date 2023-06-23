package gr.aueb.codingfacotry.AgronitorBackend.services;

import gr.aueb.codingfacotry.AgronitorBackend.models.Greenhouse;
import gr.aueb.codingfacotry.AgronitorBackend.repositories.GreenhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreenhouseService {
    private GreenhouseRepository greenhouseRepository;

    @Autowired
    public GreenhouseService(GreenhouseRepository greenhouseRepository) {
        this.greenhouseRepository = greenhouseRepository;
    }

    public Greenhouse addGreenhouse(Greenhouse greenhouse) {

        Greenhouse existingGreenhouse = greenhouseRepository.
                findByGreenhouseName(greenhouse.getGreenhouseName());
        if (existingGreenhouse != null) {
            throw new RuntimeException("Greenhouse already exists");
        }

        return greenhouseRepository.save(greenhouse);
    }

    public Greenhouse getGreenhouseByName(String greenhouseName) {
        return greenhouseRepository.findByGreenhouseName(greenhouseName);
    }
}
