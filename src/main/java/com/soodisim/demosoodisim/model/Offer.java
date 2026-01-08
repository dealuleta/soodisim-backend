package com.soodisim.demosoodisim.model;

import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    private String title;
    private String description;
    private int discountPercentage;
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private BusinessProfile business;

    public Offer() {}

    public Long getOfferId() { return offerId; }
    public void setOfferId(Long offerId) { this.offerId = offerId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(int discountPercentage) { this.discountPercentage = discountPercentage; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public BusinessProfile getBusiness() { return business; }
    public void setBusiness(BusinessProfile business) { this.business = business; }
}