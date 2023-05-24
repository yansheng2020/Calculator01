package com.example.Calculator01;

/*

import com.example.Calculator01.entity.PostcodeData;
import com.example.Calculator01.entity.ResponseData;
import com.example.Calculator01.service.PostcodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class PostcodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostcodeService postcodeService;

    @Autowired
    ObjectMapper objectMapper;

    public static final MediaType APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;

    @Test
    @WithMockUser(username = "yansheng", password = "test123", roles = "EMPLOYEE")
    public void findByPostcodeHttpRequest() throws Exception{

        PostcodeData postcodeData = new PostcodeData("1065VL",52.36234477, 4.831505362);
        when(postcodeService.findByPostcode("1065VL")).thenReturn(postcodeData);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/{postcode0}", "1065VL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.postcode", is("1065VL")))
                .andExpect(jsonPath("$.latitude", is(52.36234477)))
                .andExpect(jsonPath("$.longitude", is(4.831505362)));
    }

    @Test
    @WithMockUser(username = "sam", password = "test123", roles = {"EMPLOYEE","MANAGER"})
    public void getDistanceHttpRequest() throws Exception{

        PostcodeData Data1 = new PostcodeData("1065VL",52.36234477, 4.831505362);
        PostcodeData Data2 = new PostcodeData("8471RK",52.87352747, 5.996327647);
        when(postcodeService.findByPostcode("1065VL")).thenReturn(Data1);
        when(postcodeService.findByPostcode("8471RK")).thenReturn(Data2);
        when(postcodeService.calculateDistance(Data1,Data2)).thenReturn(97.02683289015619);


        ResponseData responseData = new ResponseData("1065VL",52.36234477, 4.831505362,
                                                     "8471RK",52.87352747, 5.996327647,
                                                     97.02683289015619, "km");
        when(postcodeService.compileResponseData(Data1,Data2,97.02683289015619)).thenReturn(responseData);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/{postcode1}/{postcode2}", "1065VL","8471RK"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.postcode1", is("1065VL")))
                .andExpect(jsonPath("$.latitude1", is(52.36234477)))
                .andExpect(jsonPath("$.longitude1", is(4.831505362)))
                .andExpect(jsonPath("$.postcode2", is("8471RK")))
                .andExpect(jsonPath("$.latitude2", is(52.87352747)))
                .andExpect(jsonPath("$.longitude2", is(5.996327647)))
                .andExpect(jsonPath("$.distance", is(97.02683289015619)))
                .andExpect(jsonPath("$.unit", is("km")));
    }

    @Test
    @WithMockUser(username = "susan", password = "test123", roles = {"EMPLOYEE","MANAGER","ADMIN"})
    public void updatePostcodeCoordinatesHttpRequest() throws Exception{

        PostcodeData updatedPostcodeData = new PostcodeData("1189WK",52.25902059,4.869899159);
        updatedPostcodeData.setId(2);

        when(postcodeService.validateUpdate(updatedPostcodeData)).thenReturn("Validation successful");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/postcodes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedPostcodeData)))
                .andExpect(status().isOk());

    }
}

*/