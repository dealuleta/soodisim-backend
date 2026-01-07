package com.soodisim.demosoodisim.controller;

import com.soodisim.demosoodisim.dto.CityDTO;
import com.soodisim.demosoodisim.model.City;
import com.soodisim.demosoodisim.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @PostMapping
    public City create(@RequestBody City city) {
        return service.createCity(city);
    }

    @GetMapping
    public List<CityDTO> getAll() {
        return service.getAllCities()
                .stream()
                .map(c -> new CityDTO(
                        c.getCityId(),
                        c.getName(),
                        c.getLatitude(),
                        c.getLongitude()
                ))
                .toList();
    }
}
