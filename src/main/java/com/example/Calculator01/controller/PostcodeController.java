package com.example.Calculator01.controller;

import com.example.Calculator01.entity.PostcodeData;
import com.example.Calculator01.entity.ResponseData;
import com.example.Calculator01.service.PostcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostcodeController {

    @Autowired
    private PostcodeService postcodeService;

    @GetMapping("/postcode/{postcode0}")
    public PostcodeData getCoordinates(@PathVariable String postcode0){

        return postcodeService.findByPostcode(postcode0);

    }

    @GetMapping("/{postcode1}/{postcode2}")
    public ResponseData getDistance(
            @PathVariable String postcode1,
            @PathVariable String postcode2){

        PostcodeData data1 = postcodeService.findByPostcode(postcode1);
        PostcodeData data2 = postcodeService.findByPostcode(postcode2);
        double theDistance = postcodeService.calculateDistance(data1, data2);

        ResponseData theResponseData = postcodeService.compileResponseData(data1, data2, theDistance);

        return theResponseData;

    }

    @PutMapping("/postcodes")
    public String updatePostcodeData(@RequestBody PostcodeData thePostcodeData){

        postcodeService.updatePostcodeCoordinates(thePostcodeData);

        return postcodeService.validateUpdate(thePostcodeData);
    }

}
