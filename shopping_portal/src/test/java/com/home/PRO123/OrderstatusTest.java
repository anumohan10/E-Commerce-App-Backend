package com.home.PRO123.model;

import com.home.PRO123.persistence.OrderstatusDAO;
import com.home.PRO123.factory.OrderstatusFactory;
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
 * Test class for Orderstatus.
 */
@RunWith(JMockit.class)
public class OrderstatusTest {
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
  public final void testOrderstatus() {
    Orderstatus m = new Orderstatus();
    Orderstatus o1 = new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2);
    assertNotEquals(o1, null);
    assertEquals(o1.getid(),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getid());
    assertEquals(o1.getorderId(),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getorderId());
    assertEquals(o1.geteta(),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).geteta());
    assertEquals(o1.getorderstatus(),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getorderstatus());
    assertEquals(o1.getitemVendorId(),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getitemVendorId());
    assertEquals(o1.getcustId(),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getcustId());
    assertEquals(o1.getquantity(),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getquantity());
    assertEquals(o1.setid(1001),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).setid(1001));
    assertEquals(o1.setorderId(1),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).setorderId(1));
    assertEquals(o1.seteta("10 min"),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).seteta("10 min"));
    assertEquals(o1.setorderstatus("Order Accepted"),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).setorderstatus("Order Accepted"));
    assertEquals(o1.setitemVendorId(1),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).setitemVendorId(1));
    assertEquals(o1.setcustId(1),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).setcustId(1));
    assertEquals(o1.setquantity(2),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).setquantity(2));
    assertEquals(o1.hashCode(),
        new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).hashCode());
    assertEquals(o1, new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OrderstatusDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Orderstatus>();
      }
    };
    new MockUp<OrderstatusFactory>() {
      @Mock
      OrderstatusDAO dao() {
        return dao;
      }
    };
    Orderstatus[] me = OrderstatusFactory.showOrderstatus();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final OrderstatusDAO dao) {
    final Orderstatus o1 = new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2);
    final ArrayList<Orderstatus> mn = new ArrayList<Orderstatus>();
    new Expectations() {
      {
        mn.add(o1);
        dao.show(); result = mn;
      }
    };
    new MockUp<OrderstatusFactory>() {
      @Mock
      OrderstatusDAO dao() {
        return dao;
      }
    };
    Orderstatus[] mn1 = OrderstatusFactory.showOrderstatus();
    assertEquals(1, mn1.length);
    assertEquals(new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getid(),
        mn1[0].getid());
    assertEquals(new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getorderId(),
        mn1[0].getorderId());
    assertEquals(new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).geteta(),
        mn1[0].geteta());
    assertEquals(new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getorderstatus(),
        mn1[0].getorderstatus());
    assertEquals(new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getitemVendorId(),
        mn1[0].getitemVendorId());
    assertEquals(new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getcustId(),
        mn1[0].getcustId());
    assertEquals(new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2).getquantity(),
        mn1[0].getquantity());
  }
}
