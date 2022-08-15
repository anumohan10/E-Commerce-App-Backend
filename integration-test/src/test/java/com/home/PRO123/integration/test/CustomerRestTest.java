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

public class CustomerRestTest {

	@Test
	public void testCustomerLogin() throws AssertionError, URISyntaxException {
	Customer[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/customer/customerlogin/iopjym@gmail.com/iopjy")).getBody().as(Customer[].class);
	assertEquals(1, res.length);
	assertEquals(1, res[0].getcustId());
	assertEquals("iopjy", res[0].getcustName());
	assertEquals(9082673456L, res[0].getcustPhno());
	assertEquals("iopjym@gmail.com", res[0].getcustEmailid());
	assertEquals("9904fd42e4977d5815b5d5679a935ed5", res[0].getpasswrd());
	assertEquals("Mumbai", res[0].getcustAddress());
	}

	@Test
	public void testCustomerSignup() throws AssertionError, URISyntaxException {
		Response response = null;
		try { 
			response = given()
			   .contentType(ContentType.JSON)
			   .post(CommonUtil.getURI("/api/customer/customersignup/labcgfh/9619516387/labcgfh@gmail.com/labcgfh12345/Karnataka"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

	@Test
	public void testCustupdatePhNo() throws AssertionError, URISyntaxException {
		Response response = null;
		try { 
			response = given()
			   .contentType(ContentType.JSON)
			   .put(CommonUtil.getURI("/api/customer/customerupdatePhone/9764529198/labcgfh@gmail.com"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

	@Test
	public void testCustupdateEid() throws AssertionError, URISyntaxException {
		Response response = null;
		try { 
			response = given()
			   .contentType(ContentType.JSON)
			   .put(CommonUtil.getURI("/api/customer/customerupdateEmailId/labcgfh26@gmail.com/2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

	@Test
	public void testCustupdatepwd() throws AssertionError, URISyntaxException {
		Response response = null;
		try { 
			response = given()
			   .contentType(ContentType.JSON)
			   .put(CommonUtil.getURI("/api/customer/customerupdatePassword/labcgfh0123/labcgfh26@gmail.com"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

	@Test
	public void testCustdeleteAcc() throws AssertionError, URISyntaxException {
		Response response = null;
		try { 
			response = given()
			   .contentType(ContentType.JSON)
			   .delete(CommonUtil.getURI("/api/customer/customerdeleteAccount/labcgfh26@gmail.com/labcgfh0123"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

	@Test
	public void testCustomerById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/Customer/1010")).then().assertThat().statusCode(404);
	}
}
