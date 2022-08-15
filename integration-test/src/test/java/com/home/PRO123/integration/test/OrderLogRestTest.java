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

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class OrderLogRestTest {

	@Test
	public void testOrderLogList() throws AssertionError, URISyntaxException {
	OrderLog[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderlog")).getBody().as(OrderLog[].class);
	assertEquals(1, res.length);
	assertEquals(1, res[0].getorderId());
	assertEquals(1, res[0].getcustId());
	assertEquals(1, res[0].getitemId());
	assertEquals("Noodles", res[0].getitemName());
    assertEquals(1, res[0].getvendorId());
    assertEquals(500, res[0].gettotalCost());
	}

    @Test
	public void testOrderLogbyId() throws AssertionError, URISyntaxException {
	OrderLog[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderlog/showbyorderlogId/1")).getBody().as(OrderLog[].class);
	assertEquals(1, res.length);
	assertEquals(1, res[0].getorderId());
	assertEquals(1, res[0].getcustId());
	assertEquals(1, res[0].getitemId());
	assertEquals("Noodles", res[0].getitemName());
    assertEquals(1, res[0].getvendorId());
    assertEquals(500, res[0].gettotalCost());
	}

        @Test
	public void testOrderLogbycustId() throws AssertionError, URISyntaxException {
	OrderLog[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderlog/showbycustId/1")).getBody().as(OrderLog[].class);
	assertEquals(1, res.length);
	assertEquals(1, res[0].getorderId());
	assertEquals(1, res[0].getcustId());
	assertEquals(1, res[0].getitemId());
	assertEquals("Noodles", res[0].getitemName());
    assertEquals(1, res[0].getvendorId());
    assertEquals(500, res[0].gettotalCost());
	}

        @Test
	public void testOrderLogbyvendorId() throws AssertionError, URISyntaxException {
	OrderLog[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderlog/showbyvendorId/1")).getBody().as(OrderLog[].class);
	assertEquals(1, res.length);
	assertEquals(1, res[0].getorderId());
	assertEquals(1, res[0].getcustId());
	assertEquals(1, res[0].getitemId());
	assertEquals("Noodles", res[0].getitemName());
    assertEquals(1, res[0].getvendorId());
    assertEquals(500, res[0].gettotalCost());
	}

        @Test
	public void testOrderLogbycustIdRecent() throws AssertionError, URISyntaxException {
	OrderLog[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderlog/showbycustId/recent/1")).getBody().as(OrderLog[].class);
	assertEquals(1, res.length);
	assertEquals(1, res[0].getorderId());
	assertEquals(1, res[0].getcustId());
	assertEquals(1, res[0].getitemId());
	assertEquals("Noodles", res[0].getitemName());
    assertEquals(1, res[0].getvendorId());
    assertEquals(500, res[0].gettotalCost());
	}

        @Test
	public void testOrderLogbyvendorIdRecent() throws AssertionError, URISyntaxException {
	OrderLog[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderlog/showbyvendorId/recent/1")).getBody().as(OrderLog[].class);
	assertEquals(1, res.length);
	assertEquals(1, res[0].getorderId());
	assertEquals(1, res[0].getcustId());
	assertEquals(1, res[0].getitemId());
	assertEquals("Noodles", res[0].getitemName());
    assertEquals(1, res[0].getvendorId());
    assertEquals(500, res[0].gettotalCost());
	}

	@Test
	public void testOrderLogById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/OrderLog/1010")).then().assertThat().statusCode(404);
	}
	
}
