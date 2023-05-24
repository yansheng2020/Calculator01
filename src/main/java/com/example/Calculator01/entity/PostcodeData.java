package com.example.Calculator01.entity;

import jakarta.persistence.*;

@Entity
@Table(name="postcode_coordinates_three_nl")
public class PostcodeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="post_code")
    private String postcode;
    @Column(name="latitude")
    private double latitude;
    @Column(name="longitude")
    private double longitude;

    public PostcodeData(){

    }

    public PostcodeData(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PostcodeData(String postcode, double latitude, double longitude) {
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "PostcodeData{" +
                "id=" + id +
                ", postcode='" + postcode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
