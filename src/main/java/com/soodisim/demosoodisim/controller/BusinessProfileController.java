package com.soodisim.demosoodisim.controller;

import com.soodisim.demosoodisim.model.BusinessProfile;
import com.soodisim.demosoodisim.service.BusinessProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business")
public class BusinessProfileController {

    private final BusinessProfileService service;

    public BusinessProfileController(BusinessProfileService service) {
        this.service = service;
    }

    @PostMapping
    public BusinessProfile create(@RequestParam Long userId,
                                  @RequestBody BusinessProfile profile) {
        return service.createBusinessProfile(userId, profile);
    }
}