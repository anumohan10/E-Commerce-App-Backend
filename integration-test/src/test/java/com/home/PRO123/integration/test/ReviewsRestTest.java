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

public class ReviewsRestTest {

	@Test
	public void testReviewsListbyratings() throws AssertionError, URISyntaxException {
	Reviews[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/reviews/reviewsbyratings/3")).getBody().as(Reviews[].class);
	assertEquals(1, res.length);
	assertEquals(1000, res[0].getreviewsId());
	assertEquals("Good One", res[0].getcomments());
	assertEquals(3, res[0].getratings());
	assertEquals(001, res[0].getcustId());
	assertEquals(001, res[0].getfoodVendorId());
    assertEquals(001, res[0].getfoodId());
    assertEquals("Noodles", res[0].getfoodName());
	}

	@Test
	public void testReviewsListbyfoodId() throws AssertionError, URISyntaxException {
	Reviews[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/reviews/reviewsbyfoodId/1")).getBody().as(Reviews[].class);
	assertEquals(1, res.length);
	
	assertEquals(1000, res[0].getreviewsId());
	assertEquals("Good One", res[0].getcomments());
	assertEquals(3, res[0].getratings());
	assertEquals(001, res[0].getcustId());
	assertEquals(001, res[0].getfoodVendorId());
    assertEquals(001, res[0].getfoodId());
    assertEquals("Noodles", res[0].getfoodName());
	}

    @Test
	public void testReviewsListbyfoodvendorId() throws AssertionError, URISyntaxException {
	Reviews[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/reviews/reviewsbyfoodVendorId/1")).getBody().as(Reviews[].class);
	assertEquals(1, res.length);
	assertEquals(1000, res[0].getreviewsId());
	assertEquals("Good One", res[0].getcomments());
	assertEquals(3, res[0].getratings());
	assertEquals(001, res[0].getcustId());
	assertEquals(001, res[0].getfoodVendorId());
    assertEquals(001, res[0].getfoodId());
    assertEquals("Noodles", res[0].getfoodName());
	}

    @Test
	public void testReviewsListbyratingOrder() throws AssertionError, URISyntaxException {
	Reviews[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/reviews/ratingsorder")).getBody().as(Reviews[].class);
	assertEquals(1, res.length);
	assertEquals(1000, res[0].getreviewsId());
	assertEquals("Good One", res[0].getcomments());
	assertEquals(3, res[0].getratings());
	assertEquals(001, res[0].getcustId());
	assertEquals(001, res[0].getfoodVendorId());
    assertEquals(001, res[0].getfoodId());
    assertEquals("Noodles", res[0].getfoodName());
	}

    @Test
	public void testReviewsAdd() throws AssertionError, URISyntaxException {
		Response response = null;
		try { 
			response = given()
			   .contentType(ContentType.JSON)
			   .post(CommonUtil.getURI("/api/reviews/reviewsadd/Good/5/2/2/1/Pasta"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

    @Test
	public void testupdateRating() throws AssertionError, URISyntaxException {
		Response response = null;
		try { 
			response = given()
			   .contentType(ContentType.JSON)
			   .put(CommonUtil.getURI("/api/reviews/customerupdateratings/4/1001"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

    @Test
	public void testupdateComments() throws AssertionError, URISyntaxException {
		Response response = null;
		try { 
			response = given()
			   .contentType(ContentType.JSON)
			   .put(CommonUtil.getURI("/api/reviews/customerupdatecomments/Nice/1001"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

    @Test
	public void testCustdeleteRev() throws AssertionError, URISyntaxException {
		Response response = null;
		try { 
			response = given()
			   .contentType(ContentType.JSON)
			   .delete(CommonUtil.getURI("/api/reviews/reviewsdelete/1001/2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

	@Test
	public void testReviewsById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/Reviews/1010")).then().assertThat().statusCode(404);
	}
}
