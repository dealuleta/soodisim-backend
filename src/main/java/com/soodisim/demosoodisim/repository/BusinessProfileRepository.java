package com.soodisim.demosoodisim.repository;

import com.soodisim.demosoodisim.model.BusinessProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessProfileRepository extends JpaRepository<BusinessProfile, Long> {
}