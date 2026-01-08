package com.soodisim.demosoodisim.service;

import com.soodisim.demosoodisim.model.BusinessProfile;
import com.soodisim.demosoodisim.model.User;
import com.soodisim.demosoodisim.repository.BusinessProfileRepository;
import com.soodisim.demosoodisim.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessProfileService {

    private final BusinessProfileRepository businessRepo;
    private final UserRepository userRepo;

    public BusinessProfileService(BusinessProfileRepository businessRepo, UserRepository userRepo) {
        this.businessRepo = businessRepo;
        this.userRepo = userRepo;
    }

    public BusinessProfile createBusinessProfile(Long userId, BusinessProfile profile) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        profile.setUser(user);
        return businessRepo.save(profile);
    }
}