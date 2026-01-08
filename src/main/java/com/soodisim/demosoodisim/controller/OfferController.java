package com.soodisim.demosoodisim.controller;

import com.soodisim.demosoodisim.model.Offer;
import com.soodisim.demosoodisim.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService service;

    public OfferController(OfferService service) {
        this.service = service;
    }

    @PostMapping
    public Offer create(@RequestParam Long businessId,
                        @RequestBody Offer offer) {
        return service.createOffer(businessId, offer);
    }

    @GetMapping("/business/{businessId}")
    public List<Offer> getByBusiness(@PathVariable Long businessId) {
        return service.getOffersByBusiness(businessId);
    }
}