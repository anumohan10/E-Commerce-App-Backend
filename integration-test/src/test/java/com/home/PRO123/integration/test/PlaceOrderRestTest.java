package com.home.PRO123.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class PlaceOrderRestTest {
	@Test
	public void testUpdate() throws AssertionError, URISyntaxException {
	    Response response= null;
	    try {
		    response = given()
                .contentType(ContentType.JSON).post(CommonUtil.getURI("/api/placeorder/placeorder/1/1/1/1"));
	    } catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals(204,response.getStatusCode());
	}
}
