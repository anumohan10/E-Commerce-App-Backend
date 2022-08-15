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

public class ItemVendorRestTest {

	@Test
	public void testItemVendorList() throws AssertionError, URISyntaxException {
	ItemVendor[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/Itemvendor")).getBody().as(ItemVendor[].class);
	assertEquals(1, res.length);
	assertEquals(001, res[0].getItemVendorId());
	assertEquals("abcdf", res[0].getvendorName());
	assertEquals(7337662360L, res[0].getvendorPhoneno());
	assertEquals("abcdf2602@gmail.com", res[0].getvendorEmailId());
	assertEquals("81dc9bdb52d04dc20036dbd8313ed055", res[0].getpwd());
	}

    @Test
	public void testItemVendorlogin() throws AssertionError, URISyntaxException {
	ItemVendor[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/Itemvendor/Itemvendorlogin/abcdf2602@gmail.com/81dc9bdb52d04dc20036dbd8313ed055")).getBody().as(ItemVendor[].class);
	assertEquals(1, res.length);
	assertEquals(001, res[0].getItemVendorId());
	assertEquals("abcdf", res[0].getvendorName());
	assertEquals(7337892360L, res[0].getvendorPhoneno());
	assertEquals("abcdf2602@gmail.com", res[0].getvendorEmailId());
	assertEquals("81dc9bdb52d04dc20036dbd8313ed055", res[0].getpwd());
	}

    @Test
	public void testItemVendorsignup() throws AssertionError, URISyntaxException {
    Response response = null;
    try{
            response = given()
                .contentType(ContentType.JSON)
                .post(CommonUtil.getURI ("/api/Itemvendor/Itemvendorsignup/100/iolp/9898989898/iolp12@gmail.com/iolp@12"));
       } catch (Exception e) {
           e.printStackTrace();
       } 
	assertEquals(200,response.getStatusCode());
	}

    @Test
	public void testItemvendorupdatePhone() throws AssertionError, URISyntaxException {
    Response response = null;
    try{
            response = given()
                .contentType(ContentType.JSON)
                .put(CommonUtil.getURI ("/api/Itemvendor/ItemvendorupdatePhone/9879879870/iolp12@gmail.com"));
       } catch (Exception e) {
           e.printStackTrace();
       } 
	assertEquals(200,response.getStatusCode());
	}

    @Test
	public void testItemvendorupdateEmailId() throws AssertionError, URISyntaxException {
    Response response = null;
    try{
            response = given()
                .contentType(ContentType.JSON)
                .put(CommonUtil.getURI ("/api/Itemvendor/ItemvendorupdateEmailId/iolp123@gmail.com/9879879870"));
       } catch (Exception e) {
           e.printStackTrace();
       } 
	assertEquals(200,response.getStatusCode());
	}

    @Test
	public void testItemvendorupdatePassword() throws AssertionError, URISyntaxException {
    Response response = null;
    try{
            response = given()
                .contentType(ContentType.JSON)
                .put(CommonUtil.getURI ("/api/Itemvendor/ItemvendorupdatePassword/iolp@123/9879879870"));
       } catch (Exception e) {
           e.printStackTrace();
       } 
	assertEquals(200,response.getStatusCode());
	}
    
    @Test
	public void testItemvendorupdateForgetPwd() throws AssertionError, URISyntaxException {
    Response response = null;
    try{
            response = given()
                .contentType(ContentType.JSON)
                .put(CommonUtil.getURI ("/api/Itemvendor/ItemvendorupdateForgetPwd/iolp@1234/iolp123@gmail.com"));
       } catch (Exception e) {
           e.printStackTrace();
       } 
	assertEquals(200,response.getStatusCode());
	}
    
    @Test
	public void testItemvendordeleteaccount() throws AssertionError, URISyntaxException {
    Response response = null;
    try{
            response = given()
                .contentType(ContentType.JSON)
                .delete(CommonUtil.getURI ("/api/Itemvendor/Itemvendordeleteaccount/iolp@1234/iolp123@gmail.com"));
       } catch (Exception e) {
           e.printStackTrace();
       } 
	assertEquals(200,response.getStatusCode());
	}

	@Test
	public void testItemVendorById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/Itemvendor/1010")).then().assertThat().statusCode(404);
	}
}
