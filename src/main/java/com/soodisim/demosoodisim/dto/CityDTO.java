package com.soodisim.demosoodisim.dto;

public class CityDTO {

    private Long cityId;
    private String name;
    private double latitude;
    private double longitude;

    public CityDTO(Long cityId, String name, double latitude, double longitude) {
        this.cityId = cityId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getCityId() { return cityId; }
    public String getName() { return name; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}
