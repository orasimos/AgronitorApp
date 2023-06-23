package gr.aueb.codingfacotry.AgronitorBackend.controllers;

import gr.aueb.codingfacotry.AgronitorBackend.models.Greenhouse;
import gr.aueb.codingfacotry.AgronitorBackend.services.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greenhouses")
public class GreenhouseController {

    private GreenhouseService greenhouseService;

    @Autowired
    public GreenhouseController(GreenhouseService greenhouseService) {
        this.greenhouseService = greenhouseService;
    }

    @PostMapping
    public Greenhouse createGreenhouse(@RequestBody Greenhouse greenhouse) {
        return greenhouseService.addGreenhouse(greenhouse);
    }

    @GetMapping
    public Greenhouse getGreenhouseByGreenhouseName(@RequestParam String greenhouseName) {
        return greenhouseService.getGreenhouseByName(greenhouseName);
    }
}
