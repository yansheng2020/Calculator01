package com.example.Calculator01.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
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

    public PostcodeData(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PostcodeData(String postcode, double latitude, double longitude) {
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PostcodeData other = (PostcodeData) obj;

        // Compare each variable for equality
        return Objects.equals(id, other.id) &&
                Objects.equals(postcode, other.postcode) &&
                Objects.equals(latitude, other.latitude) &&
                Objects.equals(longitude, other.longitude);
    }


}
