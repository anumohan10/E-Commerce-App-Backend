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

public class itemRestTest {

	@Test
	public void testitemList() throws AssertionError, URISyntaxException {
	item[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/item")).getBody().as(item[].class);
	assertEquals(2, res.length);
	assertEquals(1, res[0].getitemId());
	assertEquals("noodles", res[0].getitemName());
	assertEquals("food item - maggi", res[0].getitemType());
	assertEquals("yes", res[0].getavailability());
	assertEquals(001, res[0].getvendorId());
	assertEquals(120, res[0].getitemCost());
	}

	@Test
	public void testitemListbyfdId() throws AssertionError, URISyntaxException {
	item[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/item/showbyitemId/1")).getBody().as(item[].class);
	assertEquals(1, res.length);
	assertEquals(1, res[0].getitemId());
	assertEquals("noodles", res[0].getitemName());
	assertEquals("food item - maggi", res[0].getitemType());
	assertEquals("yes", res[0].getavailability());
	assertEquals(001, res[0].getvendorId());
	assertEquals(120, res[0].getitemCost());
	}

	@Test
	public void testitemListbyfdtype() throws AssertionError, URISyntaxException {
	item[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/item/showbyitemtype/food item - maggi")).getBody().as(item[].class);
	assertEquals(2, res.length);
	assertEquals(1, res[0].getitemId());
	assertEquals("noodles", res[0].getitemName());
	assertEquals("food item - maggi", res[0].getitemType());
	assertEquals("yes", res[0].getavailability());
	assertEquals(001, res[0].getvendorId());
	assertEquals(120, res[0].getitemCost());
	}

	@Test
	public void testitemListbycuisne() throws AssertionError, URISyntaxException {
	item[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/item/showbycuisine/chinese")).getBody().as(item[].class);
	assertEquals(2, res.length);
	assertEquals(1, res[0].getitemId());
	assertEquals("noodles", res[0].getitemName());
	assertEquals("food item - maggi", res[0].getitemType());
	assertEquals("yes", res[0].getavailability());
	assertEquals(001, res[0].getvendorId());
	assertEquals(120, res[0].getitemCost());
	}
	@Test
	public void testitemListbyfilteritem() throws AssertionError, URISyntaxException {
	item[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/item/filteritem/food item - maggi/yes")).getBody().as(item[].class);
	assertEquals(2, res.length);
	assertEquals(1, res[0].getitemId());
	assertEquals("noodles", res[0].getitemName());
	assertEquals("food item - maggi", res[0].getitemType());
	assertEquals("yes", res[0].getavailability());
	assertEquals(001, res[0].getvendorId());
	assertEquals(120, res[0].getitemCost());
	}
	@Test
	public void testitemListbyfilteritemdscn() throws AssertionError, URISyntaxException {
	item[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/item/filteritemdsc/food item - maggi/yes")).getBody().as(item[].class);
	assertEquals(2, res.length);
	assertEquals(1, res[0].getitemId());
	assertEquals("noodles", res[0].getitemName());
	assertEquals("food item - maggi", res[0].getitemType());
	assertEquals("yes", res[0].getavailability());
	assertEquals(001, res[0].getvendorId());
	assertEquals(120, res[0].getitemCost());
	}
	@Test
	public void testitemListbypricerange() throws AssertionError, URISyntaxException {
	item[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/item/showbypricerange/50/150")).getBody().as(item[].class);
	assertEquals(2, res.length);
	assertEquals(1, res[0].getitemId());
	assertEquals("noodles", res[0].getitemName());
	assertEquals("food item - maggi", res[0].getitemType());
	assertEquals("yes", res[0].getavailability());
	assertEquals(001, res[0].getvendorId());
	assertEquals(120, res[0].getitemCost());
	}

	@Test
	public void testiteminsert() throws AssertionError, URISyntaxException {
		Response response = null;

		try {
			response = given().contentType(ContentType.JSON).post(CommonUtil.getURI("/api/item/insertitem/102/momos/food item - maggi/chinese/yes/001/120"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}
	@Test
	public void testFdnameupdate() throws AssertionError, URISyntaxException {
		Response response = null;

		try {
			response = given().contentType(ContentType.JSON).put(CommonUtil.getURI("/api/item/updatename/tandoori-momos/102"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}
	@Test
	public void testitemavail() throws AssertionError, URISyntaxException {
		Response response = null;

		try {
			response = given().contentType(ContentType.JSON).put(CommonUtil.getURI("/api/item/updateavail/no/107"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}
	@Test
	public void testitemcostchange() throws AssertionError, URISyntaxException {
		Response response = null;

		try {
			response = given().contentType(ContentType.JSON).put(CommonUtil.getURI("/api/item/updatecost/90/107"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}
	@Test
	public void testitemdelete() throws AssertionError, URISyntaxException {
		Response response = null;

		try {
			response = given().contentType(ContentType.JSON).delete(CommonUtil.getURI("/api/item/deletefd/107"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

	@Test
	public void testitemById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/item/1010")).then().assertThat().statusCode(404);
	}
}
