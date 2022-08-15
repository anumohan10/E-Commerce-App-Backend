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

public class CouponRestTest {

	@Test
	public void testCouponList() throws AssertionError, URISyntaxException {
	Coupon[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/coupon")).getBody().as(Coupon[].class);
	assertEquals(2, res.length);
	assertEquals(2, res[0].getcouponId());
	assertEquals("coupon2021", res[0].getcouponCode());
	assertEquals(1, res[0].getcustId());
	assertEquals(1, res[0].getorderId());
	}
    
    @Test
	public void testlistcoupon() throws AssertionError, URISyntaxException {
    Response response = null;
    try{
            response = given()
                .contentType(ContentType.JSON)
                .post(CommonUtil.getURI ("/api/coupon/listcoupon/7/Coupon2023/8/9"));
       } catch (Exception e) {
           e.printStackTrace();
       } 
	assertEquals(200,response.getStatusCode());
	}
    
    @Test
	public void testupdateCpncd() throws AssertionError, URISyntaxException {
    Response response = null;
    try{
            response = given()
                .contentType(ContentType.JSON)
                .put(CommonUtil.getURI ("/api/coupon/updateCpncd/coupon2024/7"));
       } catch (Exception e) {
           e.printStackTrace();
       } 
	assertEquals(500,response.getStatusCode());
	}

    @Test
	public void testItemVendorById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/Itemvendor/1010")).then().assertThat().statusCode(404);
	}
}
