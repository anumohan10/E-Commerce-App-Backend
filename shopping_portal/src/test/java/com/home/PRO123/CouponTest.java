package com.home.PRO123.model;

import com.home.PRO123.persistence.CouponDAO;
import com.home.PRO123.factory.CouponFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;

/**
 * Test class for Coupon.
 */
@RunWith(JMockit.class)
public class CouponTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testCoupon() {
    Coupon m = new Coupon();
    Coupon m1 = new Coupon(002, "coupon2021", 55, 35);
    assertNotEquals(m1, null);
    assertEquals(m1.getcouponId(),
        new Coupon(002, "coupon2021", 55, 35).getcouponId());
    assertEquals(m1.getcouponCode(),
        new Coupon(002, "coupon2021", 55, 35).getcouponCode());
    assertEquals(m1.getcustId(),
        new Coupon(002, "coupon2021", 55, 35).getcustId());
    assertEquals(m1.getorderId(),
        new Coupon(002, "coupon2021", 55, 35).getorderId());
    assertEquals(m1.setcouponId(002),
        new Coupon(002, "coupon2021", 55, 35).setcouponId(002));
    assertEquals(m1.setcouponCode("coupon2021"),
        new Coupon(002, "coupon2021", 55, 35).setcouponCode("coupon2021"));
    assertEquals(m1.setcustId(55),
        new Coupon(002, "coupon2021", 55, 35).setcustId(55));
    assertEquals(m1.setorderId(35),
        new Coupon(002, "coupon2021", 55, 35).setorderId(35));
    assertEquals(m1.hashCode(),
        new Coupon(002, "coupon2021", 55, 35).hashCode());
    assertEquals(m1, new Coupon(002, "coupon2021", 55, 35));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final CouponDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Coupon>();
      }
    };
    new MockUp<CouponFactory>() {
      @Mock
      CouponDAO dao() {
        return dao;
      }
    };
    Coupon[] me = CouponFactory.showMenu();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final CouponDAO dao) {
    final Coupon m1 = new Coupon(002, "coupon2021", 55, 35);
    final ArrayList<Coupon> mn = new ArrayList<Coupon>();
    new Expectations() {
      {
        mn.add(m1);
        dao.show(); result = mn;
      }
    };
    new MockUp<CouponFactory>() {
      @Mock
      CouponDAO dao() {
        return dao;
      }
    };
    Coupon[] mn1 = CouponFactory.showMenu();
    assertEquals(1, mn1.length);
    assertEquals(new Coupon(002, "coupon2021", 55, 35).getcouponId(),
        mn1[0].getcouponId());
    assertEquals(new Coupon(002, "coupon2021", 55, 35).getcouponCode(),
        mn1[0].getcouponCode());
    assertEquals(new Coupon(002, "coupon2021", 55, 35).getcustId(),
        mn1[0].getcustId());
    assertEquals(new Coupon(002, "coupon2021", 55, 35).getorderId(),
        mn1[0].getorderId());
  }
}
