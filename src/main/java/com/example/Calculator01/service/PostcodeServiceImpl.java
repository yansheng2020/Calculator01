package com.example.Calculator01.service;

import com.example.Calculator01.dao.PostcodeDAO;
import com.example.Calculator01.entity.PostcodeData;
import com.example.Calculator01.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PostcodeServiceImpl implements PostcodeService{

    private final static double EARTH_RADIUS = 6371;
    @Autowired
    private PostcodeDAO postcodeDAO;

    @Override
    public PostcodeData findByPostcode(String thePostcode) {

        return postcodeDAO.findByPostcode(thePostcode);

    }

    @Override
    @Transactional
    public void updatePostcodeCoordinates(PostcodeData thePostcodeData) {

        postcodeDAO.updatePostcodeCoordinates(thePostcodeData);

    }

    @Override
    public ResponseData calculateDistance(String startPostcode, String endPostcode) {

        PostcodeData startCoordinates = postcodeDAO.findByPostcode(startPostcode);
        PostcodeData endCoordinates = postcodeDAO.findByPostcode(endPostcode);

        var unit = "km";
        var latitude = startCoordinates.getLatitude();
        var longitude = startCoordinates.getLongitude();
        var latitude2 = endCoordinates.getLatitude();
        var longitude2 = endCoordinates.getLongitude();

        var lon1Radians = Math.toRadians(longitude);
        var lon2Radians = Math.toRadians(longitude2);
        var lat1Radians = Math.toRadians(latitude);
        var lat2Radians = Math.toRadians(latitude2);

        var a = haversine(lat1Radians, lat2Radians)
                + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);

        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        var distance = (EARTH_RADIUS * c);

        return new ResponseData(startPostcode, latitude, longitude, endPostcode, latitude2, longitude2, distance, unit);

    }


    @Override
    public String validateUpdate(PostcodeData thePostcodeData) {

        PostcodeData updatedPostcodeData = postcodeDAO.findByPostcode(thePostcodeData.getPostcode());

        String output;

        if (updatedPostcodeData.getLatitude() == thePostcodeData.getLatitude() && updatedPostcodeData.getLongitude() == thePostcodeData.getLongitude()){
            output = "coordinates are successfully updated;\n"
                    + "\nselected postcode: "+thePostcodeData.getPostcode()
                    + "\nnew latitude: " + updatedPostcodeData.getLatitude()
                    + "\nnew longitude: " + updatedPostcodeData.getLongitude()
            ;
        }else{
            output = "an error occurred";
        }

        return output;
    }


    private double haversine(double degree1, double degree2) {
        return square(Math.sin((degree1 - degree2) / 2.0));
    }

    private double square(double x) {
        return x * x;
    }
}
