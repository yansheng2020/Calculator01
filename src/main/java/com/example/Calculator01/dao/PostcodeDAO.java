package com.example.Calculator01.dao;

import com.example.Calculator01.entity.PostcodeData;

public interface PostcodeDAO {

    PostcodeData findByPostcode(String thePostcode);

    void updatePostcodeCoordinates(PostcodeData thePostcodeData);

}
