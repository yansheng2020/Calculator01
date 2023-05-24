package com.example.Calculator01.service;

import com.example.Calculator01.entity.PostcodeData;
import com.example.Calculator01.entity.ResponseData;

public interface PostcodeService {

    PostcodeData findByPostcode(String thePostcode);

    void updatePostcodeCoordinates(PostcodeData thePostcodeData);

    double calculateDistance(PostcodeData data1, PostcodeData data2);

    ResponseData compileResponseData(PostcodeData data1, PostcodeData data2, double theDistance);

    String validateUpdate(PostcodeData thePostcodeData);

}
