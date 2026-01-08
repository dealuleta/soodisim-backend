package com.soodisim.demosoodisim.service;

import com.soodisim.demosoodisim.model.BusinessProfile;
import com.soodisim.demosoodisim.model.Offer;
import com.soodisim.demosoodisim.repository.BusinessProfileRepository;
import com.soodisim.demosoodisim.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepo;
    private final BusinessProfileRepository businessRepo;

    public OfferService(OfferRepository offerRepo, BusinessProfileRepository businessRepo) {
        this.offerRepo = offerRepo;
        this.businessRepo = businessRepo;
    }

    public Offer createOffer(Long businessId, Offer offer) {
        BusinessProfile business = businessRepo.findById(businessId)
                .orElseThrow(() -> new RuntimeException("Business not found"));
        offer.setBusiness(business);
        return offerRepo.save(offer);
    }

    public List<Offer> getOffersByBusiness(Long businessId) {
        return offerRepo.findByBusiness_BusinessId(businessId);
    }
}