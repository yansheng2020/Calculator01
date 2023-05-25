package com.example.Calculator01;

import com.example.Calculator01.dao.PostcodeDAO;
import com.example.Calculator01.entity.PostcodeData;
import com.example.Calculator01.entity.ResponseData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

public class PostcodeControllerTest extends AbstractTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    @DisplayName("validate if controller works to get coordinates using client postcode input")
    public void findByPostcode() throws Exception {
        var expected = new PostcodeData("8471RK",52.87352747,5.996327647);
        expected.setId(4);

        var uri = "/api/v1/postcode/8471RK";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        var status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);

        var content = mvcResult.getResponse().getContentAsString();
        var mockResult = super.mapFromJson(content, PostcodeData.class);
        assertEquals(expected, mockResult);

    }

    @Test
    @DisplayName("validate if controller works to calculate the distance")
    public void calculateDistance() throws Exception{

        var expected = new ResponseData("8471RK",52.87352747,5.996327647,
                                                 "7231JH",52.13855772,6.225588242,
                                                 83.18479947381374,"km");

        var uri = "/api/v1/distance/8471RK/7231JH";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        var status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);

        var content = mvcResult.getResponse().getContentAsString();
        var mockResult = super.mapFromJson(content, ResponseData.class);
        assertEquals(expected, mockResult);

    }

    @Test
    @DisplayName("validate if controller works to get coordinates updated properly")
    public void updateCoordinates() throws Exception {

        var clientInput = new PostcodeData("4255GC",52.0,6.0);
        clientInput.setId(1000);

        var expected = "coordinates are successfully updated;\n"
                + "\nselected postcode: "+ "4255GC"
                + "\nnew latitude: " + 52.0
                + "\nnew longitude: " + 6.0;

        var uri = "/api/v1/newCoordinates";
        var clientInputJson = super.mapToJson(clientInput);

        MvcResult mvcResult = mvc.perform(put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(clientInputJson)).andReturn();

        var status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);

        var content = mvcResult.getResponse().getContentAsString();
        assertEquals(expected, content);

        }
    }
