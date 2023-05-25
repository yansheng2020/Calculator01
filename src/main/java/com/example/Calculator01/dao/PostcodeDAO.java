package com.example.Calculator01.dao;

import com.example.Calculator01.entity.PostcodeData;

public interface PostcodeDAO {

    PostcodeData findByPostcode(String thePostcode);

    PostcodeData updatePostcodeCoordinates(PostcodeData thePostcodeData);

}
