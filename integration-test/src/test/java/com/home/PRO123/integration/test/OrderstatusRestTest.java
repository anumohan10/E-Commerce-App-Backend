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

public class OrderstatusRestTest {

	@Test
	public void testOrderstatusList() throws AssertionError, URISyntaxException {
	Orderstatus[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderstatus")).getBody().as(Orderstatus[].class);
	assertEquals(1, res.length);
	assertEquals(1001, res[0].getid());
	assertEquals(1, res[0].getorderId());
	assertEquals("10 min", res[0].geteta());
	assertEquals("Order Accepted", res[0].getorderstatus());
    assertEquals(1, res[0].getitemVendorId());
    assertEquals(1, res[0].getcustId());
    assertEquals(2, res[0].getquantity());
	}

    @Test
	public void testOrderstatusbyId() throws AssertionError, URISyntaxException {
	Orderstatus[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderstatus/showbyorderstatusId/1001")).getBody().as(Orderstatus[].class);
	assertEquals(1, res.length);
	assertEquals(1001, res[0].getid());
	assertEquals(1, res[0].getorderId());
	assertEquals("10 min", res[0].geteta());
	assertEquals("Order Accepted", res[0].getorderstatus());
    assertEquals(1, res[0].getitemVendorId());
    assertEquals(1, res[0].getcustId());
    assertEquals(2, res[0].getquantity());
	}

    @Test
	public void testOrderstatusbycustId() throws AssertionError, URISyntaxException {
	Orderstatus[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderstatus/showbycustId/1")).getBody().as(Orderstatus[].class);
	assertEquals(1, res.length);
	assertEquals(1001, res[0].getid());
	assertEquals(1, res[0].getorderId());
	assertEquals("10 min", res[0].geteta());
	assertEquals("Order Accepted", res[0].getorderstatus());
    assertEquals(1, res[0].getitemVendorId());
    assertEquals(1, res[0].getcustId());
    assertEquals(2, res[0].getquantity());
	}

    @Test
	public void testOrderstatusbyvendorId() throws AssertionError, URISyntaxException {
	Orderstatus[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderstatus/showbyvendorId/1")).getBody().as(Orderstatus[].class);
	assertEquals(1, res.length);
	assertEquals(1001, res[0].getid());
	assertEquals(1, res[0].getorderId());
	assertEquals("10 min", res[0].geteta());
	assertEquals("Order Accepted", res[0].getorderstatus());
    assertEquals(1, res[0].getitemVendorId());
    assertEquals(1, res[0].getcustId());
    assertEquals(2, res[0].getquantity());
	}

    @Test
	public void testOrderstatusbycustIdRecent() throws AssertionError, URISyntaxException {
	Orderstatus[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/orderstatus/showbycustId/recent/1")).getBody().as(Orderstatus[].class);
	assertEquals(1, res.length);
	assertEquals(1001, res[0].getid());
	assertEquals(1, res[0].getorderId());
	assertEquals("10 min", res[0].geteta());
	assertEquals("Order Accepted", res[0].getorderstatus());
    assertEquals(1, res[0].getitemVendorId());
    assertEquals(1, res[0].getcustId());
    assertEquals(2, res[0].getquantity());
	}

    @Test
	public void testOrderstatusbyvendorIdRecent() throws AssertionError, URISyntaxException {
	Orderstatus[] res = given().when().accept(ContentType.JSON)
        .get(CommonUtil.getURI("/api/orderstatus/showbyvendorId/recent/1")).getBody().as(Orderstatus[].class);
	assertEquals(1, res.length);
	assertEquals(1001, res[0].getid());
	assertEquals(1, res[0].getorderId());
	assertEquals("10 min", res[0].geteta());
	assertEquals("Order Accepted", res[0].getorderstatus());
    assertEquals(1, res[0].getitemVendorId());
    assertEquals(1, res[0].getcustId());
    assertEquals(2, res[0].getquantity());
	}

	@Test
	public void testOrderstatusById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/Orderstatus/1010")).then().assertThat().statusCode(404);
	}
	
}
