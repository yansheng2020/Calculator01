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
    private PostcodeDAO postcodeDAO;

    @Autowired
    public PostcodeServiceImpl(PostcodeDAO thePostcodeDAO){
        postcodeDAO = thePostcodeDAO;
    }


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
    public double calculateDistance(PostcodeData data1, PostcodeData data2) {

        double latitude = data1.getLatitude();
        double longitude = data1.getLongitude();
        double latitude2 = data2.getLatitude();
        double longitude2 = data2.getLongitude();

        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);

        double a = haversine(lat1Radians, lat2Radians)
                + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (EARTH_RADIUS * c);
    }

    @Override
    public ResponseData compileResponseData(PostcodeData data1, PostcodeData data2, double theDistance) {

        double latitude = data1.getLatitude();
        double longitude = data1.getLongitude();
        double latitude2 = data2.getLatitude();
        double longitude2 = data2.getLongitude();
        String postcode1 = data1.getPostcode();
        String postcode2 = data2.getPostcode();
        String unit = "km";

        ResponseData theResponseData = new ResponseData(postcode1, latitude, longitude, postcode2, latitude2, longitude2, theDistance, unit);

        return theResponseData;
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
