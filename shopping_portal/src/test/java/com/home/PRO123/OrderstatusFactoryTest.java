package com.home.PRO123.model;

//import com.home.PRO123.persistence.OrderstatusDAO;
import com.home.PRO123.factory.OrderstatusFactory;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.integration.junit4.JMockit;
//import java.util.ArrayList;

/**
 * Test class for OrderstatusFactory.
 */
@RunWith(JMockit.class)
public class OrderstatusFactoryTest {
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
  public final void testOrderstatusFactory() {
    final Orderstatus o1 = new Orderstatus(1001, 1, "10 min", "Order Accepted", 1, 1, 2);
    Orderstatus[] o = OrderstatusFactory.showOrderstatus();
    assertEquals(o1.hashCode(), o[0].hashCode());
  }
}
