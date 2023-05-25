package com.example.Calculator01.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(exclude={"id"})
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

    public PostcodeData(String postcode, double latitude, double longitude) {
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
