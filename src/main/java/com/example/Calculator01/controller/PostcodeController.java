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

    @GetMapping("/distance/{postcode1}/{postcode2}")
    public ResponseData getDistance(
            @PathVariable String postcode1,
            @PathVariable String postcode2){

        return postcodeService.calculateDistance(postcode1, postcode2);

    }

    @PutMapping("/postcodes")
    public String updatePostcodeData(@RequestBody PostcodeData thePostcodeData){

        postcodeService.updatePostcodeCoordinates(thePostcodeData);

        return postcodeService.validateUpdate(thePostcodeData);
    }

}
