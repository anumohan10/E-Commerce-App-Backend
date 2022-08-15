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

public class UpdateOrderRestTest {
	@Test
	public void testUpdatecust() throws AssertionError, URISyntaxException {
	    Response response= null;
	    try {
		    response = given()
                .contentType(ContentType.JSON).put(CommonUtil.getURI("/api/updateorder/cancel/1/1"));
	    } catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals(204,response.getStatusCode());
	}

    	@Test
	public void testUpdatevendor() throws AssertionError, URISyntaxException {
	    Response response= null;
	    try {
		    response = given()
                .contentType(ContentType.JSON).put(CommonUtil.getURI("/api/updateorder/update/1/5/2"));
	    } catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals(200,response.getStatusCode());
	}
}
