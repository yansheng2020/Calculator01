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
    PostcodeData postcodeDataThree = new PostcodeData();


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

        postcodeDataThree.setId(5);
        postcodeDataThree.setPostcode("7231JH");
        postcodeDataThree.setLatitude(52.0);
        postcodeDataThree.setLongitude(6.0);
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

    @DisplayName("Update coordinates of a specific postcode")
    @Test
    public void assertUpdateCoordinates(){

        when(postcodeDAO.updatePostcodeCoordinates(postcodeDataThree)).thenReturn(postcodeDataThree);
        when(postcodeDAO.findByPostcode("7231JH")).thenReturn(postcodeDataThree);

        String expected = "coordinates are successfully updated;\n"
                + "\nselected postcode: "+ "7231JH"
                + "\nnew latitude: " + 52.0
                + "\nnew longitude: " + 6.0;

        assertEquals(expected, postcodeService.updatePostcodeCoordinates(postcodeDataThree));

        verify(postcodeDAO).updatePostcodeCoordinates(postcodeDataThree);

    }

}