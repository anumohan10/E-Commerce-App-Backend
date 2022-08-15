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

public class WalletRestTest {

	@Test
	public void testWalletList() throws AssertionError, URISyntaxException {
	Wallet[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/wallet")).getBody().as(Wallet[].class);
	assertEquals(1, res.length);
	assertEquals(12346, res[0].getwalletId());
	assertEquals(1, res[0].getcustId());
	assertEquals(4260, res[0].getbalance());
	assertEquals(5012457823L, res[0].getbankaccNo());
	}

    @Test
	public void testWalletDetails() throws AssertionError, URISyntaxException {
	Wallet[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/wallet/showbywalletId/12346")).getBody().as(Wallet[].class);
	assertEquals(1, res.length);
	assertEquals(12346, res[0].getwalletId());
	assertEquals(1, res[0].getcustId());
	assertEquals(4260, res[0].getbalance());
	assertEquals(5012457823L, res[0].getbankaccNo());
    }
    @Test
	public void testBalanceupdate() throws AssertionError, URISyntaxException {
		Response response = null;

		try {
			response = given().contentType(ContentType.JSON).put(CommonUtil.getURI("/api/wallet/addbalance/12346/500"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
    }
    @Test
	public void testBankaccnoupdate() throws AssertionError, URISyntaxException {
		Response response = null;

		try {
			response = given().contentType(ContentType.JSON).put(CommonUtil.getURI("/api/wallet/updatebankacc/5012457823/1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(200,response.getStatusCode());
	}

	@Test
	public void testWalletById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/wallet/1010")).then().assertThat().statusCode(404);
	}
	
}
