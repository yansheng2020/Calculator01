package com.example.Calculator01;

import com.example.Calculator01.dao.PostcodeDAO;
import com.example.Calculator01.entity.PostcodeData;
import com.example.Calculator01.entity.ResponseData;
import com.example.Calculator01.service.PostcodeService;
import com.example.Calculator01.service.PostcodeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostcodeServiceTest {

    PostcodeData postcodeDataOne = new PostcodeData();
    PostcodeData postcodeDataTwo = new PostcodeData();

    @MockBean
    private PostcodeDAO postcodeDAO;

    @Autowired
    private PostcodeServiceImpl postcodeService;

    @BeforeEach
    public void beforeEach(){
        postcodeDataOne.setId(4);
        postcodeDataOne.setPostcode("8471RK");
        postcodeDataOne.setLatitude(52.87352747);
        postcodeDataOne.setLongitude(5.996327647);

        postcodeDataTwo.setId(5);
        postcodeDataTwo.setPostcode("7231JH");
        postcodeDataTwo.setLatitude(52.13855772);
        postcodeDataTwo.setLongitude(6.225588242);
    }

    @DisplayName("Find by postcode service")
    @Test
    public void assertFindByPostcode(){

        when(postcodeDAO.findByPostcode("8471RK")).thenReturn(postcodeDataOne);

        assertEquals(postcodeDataOne, postcodeService.findByPostcode("8471RK"));

        verify(postcodeDAO).findByPostcode("8471RK");

    }

    @DisplayName("Calculate distance between start and end")
    @Test
    public void assertDistanceCalculation(){

        when(postcodeDAO.findByPostcode("8471RK")).thenReturn(postcodeDataOne);
        when(postcodeDAO.findByPostcode("7231JH")).thenReturn(postcodeDataTwo);

        ResponseData expected = new ResponseData("8471RK",52.87352747,5.996327647,
                                                 "7231JH",52.13855772,6.225588242,
                                                 83.18479947381374,"km");

        assertEquals(expected,postcodeService.calculateDistance("8471RK","7231JH"));

        verify(postcodeDAO).findByPostcode("8471RK");
        verify(postcodeDAO).findByPostcode("7231JH");

    }



}





































/*
import com.example.Calculator01.dao.PostcodeDAO;
import com.example.Calculator01.entity.PostcodeData;
import com.example.Calculator01.entity.ResponseData;
import com.example.Calculator01.service.PostcodeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestPropertySource("/src/test/resources/application-test.properties")
@SpringBootTest

public class PostcodeServiceTest {


    @Mock
    private PostcodeDAO postcodeDAO;

    @Autowired
    private PostcodeService postcodeService;

    @Test
    public void findByPostcodeService(){

        PostcodeData postcodeData = postcodeService.findByPostcode("1065VL");

        assertEquals(52.36234477, postcodeData.getLatitude(), "find by postcode");

    }

    @Test
    public void calculateDistance(){

        PostcodeData data1 = postcodeService.findByPostcode("1065VL");
        PostcodeData data2 = postcodeService.findByPostcode("8471RK");

        assertEquals(97.02683289015619,
                postcodeService.calculateDistance(data1,data2), "calculate distance");

    }

    @Test
    public void updatePostcodeCoordinates(){

        PostcodeData updatedPostcodeData = new PostcodeData("1189WK",52.25902059,4.869899159);
        updatedPostcodeData.setId(2);

        postcodeService.updatePostcodeCoordinates(updatedPostcodeData);
        PostcodeData dbPostcodeData = postcodeService.findByPostcode("1189WK");

        assertEquals(52.25902059,
                dbPostcodeData.getLatitude(), "update latitude");

        assertEquals(4.869899159,
                dbPostcodeData.getLongitude(), "update longitude");
    }

    @Test
    public void compileResponseData(){

        PostcodeData data1 = new PostcodeData("1065VL",52.36234477,4.831505362);
        PostcodeData data2 = new PostcodeData("8471RK",52.87352747, 5.996327647);
        double theDistance = 97.02683289015619;

        ResponseData result = postcodeService.compileResponseData(data1,data2,theDistance);
        ResponseData expected = new ResponseData("1065VL",52.36234477, 4.831505362,
                "8471RK",52.87352747, 5.996327647,
                97.02683289015619, "km");

        assertAll("compile all info ",
                ()->assertEquals(expected.getPostcode1(), result.getPostcode1()),
                ()->assertEquals(expected.getLatitude1(), result.getLatitude1()),
                ()->assertEquals(expected.getLongitude1(),result.getLongitude1()),
                ()->assertEquals(expected.getPostcode2(), result.getPostcode2()),
                ()->assertEquals(expected.getLatitude2(), result.getLatitude2()),
                ()->assertEquals(expected.getLongitude2(), result.getLongitude2()),
                ()->assertEquals(expected.getDistance(), result.getDistance()),
                ()->assertEquals(expected.getUnit(), result.getUnit())
                );
    }


    @Test
    public void validateUpdateSucceed(){

        PostcodeData updatedPostcodeDataSuccess = new PostcodeData("1189WK",52.25902059,4.869899159);
        updatedPostcodeDataSuccess.setId(2);

        when(postcodeDAO.findByPostcode("1189WK")).thenReturn(updatedPostcodeDataSuccess);

        String succeededResult = postcodeService.validateUpdate(updatedPostcodeDataSuccess);
        String expectedResultIfSucceed = "coordinates are successfully updated;\n"
                + "\nselected postcode: 1189WK"
                + "\nnew latitude: 52.25902059"
                + "\nnew longitude: 4.869899159";

        assertEquals(expectedResultIfSucceed,succeededResult,"validate updated if succeeded");
    }

}

*/

