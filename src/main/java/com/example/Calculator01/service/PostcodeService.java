package com.example.Calculator01.service;

import com.example.Calculator01.entity.PostcodeData;
import com.example.Calculator01.entity.ResponseData;

public interface PostcodeService {

    PostcodeData findByPostcode(String thePostcode);

    String updatePostcodeCoordinates(PostcodeData thePostcodeData);

    ResponseData calculateDistance(String startPostcode, String endPostcode);

}
