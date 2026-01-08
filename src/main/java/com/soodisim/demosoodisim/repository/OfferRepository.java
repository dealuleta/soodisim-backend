package com.soodisim.demosoodisim.repository;

import com.soodisim.demosoodisim.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByBusiness_BusinessId(Long businessId);
}