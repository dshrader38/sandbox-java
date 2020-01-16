package io.swagger.api;

import io.swagger.model.Model200;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddApiControllerIntegrationTest {

    @Autowired
    private AddApi api;

    @Test
    public void currentWeatherDataTest() throws Exception {
        Long lhs = 789L;
        Long rhs = 789L;
        ResponseEntity<Model200> responseEntity = api.currentWeatherData(lhs, rhs);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
