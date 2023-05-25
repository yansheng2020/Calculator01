package com.example.Calculator01.entity;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ResponseData {
    private String postcode1;
    private double latitude1;
    private double longitude1;
    private String postcode2;
    private double latitude2;
    private double longitude2;
    private double distance;
    private String unit = "KM";

    public ResponseData(String postcode1, double latitude1, double longitude1, String postcode2, double latitude2, double longitude2, double distance, String unit) {
        this.postcode1 = postcode1;
        this.latitude1 = latitude1;
        this.longitude1 = longitude1;
        this.postcode2 = postcode2;
        this.latitude2 = latitude2;
        this.longitude2 = longitude2;
        this.distance = distance;
        this.unit = unit;
    }

}
