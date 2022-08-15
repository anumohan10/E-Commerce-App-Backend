package com.home.PRO123.model;

import com.home.PRO123.persistence.OrderLogDAO;
import com.home.PRO123.factory.OrderLogFactory;
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
 * Test class for OrderLog.
 */
@RunWith(JMockit.class)
public class OrderLogTest {
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
  public final void testOrderLog() {
    OrderLog m = new OrderLog();
    OrderLog o1 = new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54");
    assertNotEquals(o1, null);
    assertEquals(o1.getorderId(),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getorderId());
    assertEquals(o1.getcustId(),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getcustId());
    assertEquals(o1.getitemId(),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getitemId());
    assertEquals(o1.getitemName(),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getitemName());
    assertEquals(o1.getvendorId(),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getvendorId());
    assertEquals(o1.gettotalCost(),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").gettotalCost());
    assertEquals(o1.getorderDate(),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getorderDate());
    assertEquals(o1.setorderId(1),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").setorderId(1));
    assertEquals(o1.setcustId(1),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").setcustId(1));
    assertEquals(o1.setitemId(1),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").setitemId(1));
    assertEquals(o1.setitemName("Noodles"),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").setitemName("Noodles"));
    assertEquals(o1.setvendorId(1),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").setvendorId(1));
    assertEquals(o1.settotalCost(500),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").settotalCost(500));
    assertEquals(o1.setorderDate("2021-03-09 04:12:54"),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").setorderDate("2021-03-09 04:12:54"));
    assertEquals(o1.hashCode(),
        new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").hashCode());
    assertEquals(o1, new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54"));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OrderLogDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<OrderLog>();
      }
    };
    new MockUp<OrderLogFactory>() {
      @Mock
      OrderLogDAO dao() {
        return dao;
      }
    };
    OrderLog[] me = OrderLogFactory.showOrderLog();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final OrderLogDAO dao) {
    final OrderLog o1 = new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54");
    final ArrayList<OrderLog> mn = new ArrayList<OrderLog>();
    new Expectations() {
      {
        mn.add(o1);
        dao.show(); result = mn;
      }
    };
    new MockUp<OrderLogFactory>() {
      @Mock
      OrderLogDAO dao() {
        return dao;
      }
    };
    OrderLog[] mn1 = OrderLogFactory.showOrderLog();
    assertEquals(1, mn1.length);
    assertEquals(new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getorderId(),
        mn1[0].getorderId());
    assertEquals(new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getcustId(),
        mn1[0].getcustId());
    assertEquals(new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getitemId(),
        mn1[0].getitemId());
    assertEquals(new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getitemName(),
        mn1[0].getitemName());
    assertEquals(new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getvendorId(),
        mn1[0].getvendorId());
    assertEquals(new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").gettotalCost(),
        mn1[0].gettotalCost());
    assertEquals(new OrderLog(1, 1, 1, "Noodles", 1, 500, "2021-03-09 04:12:54").getorderDate(),
        mn1[0].getorderDate());
  }
}
