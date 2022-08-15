package com.home.PRO123.model;

//import com.home.PRO123.persistence.ItemVendorDAO;
import com.home.PRO123.factory.ItemVendorFactory;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

//import mockit.Expectations;
//import mockit.MockUp;
//import mockit.Mocked;
//import mockit.Mock;
import mockit.integration.junit4.JMockit;
//import java.util.ArrayList;

/**
 * Test class for ItemVendor.
 */
@RunWith(JMockit.class)
public class ItemVendorFactoryTest {
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
  public final void testItemVendorFactory() {
    final ItemVendor m1 = new ItemVendor(001, "abcdf", 7337672360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055");
    ItemVendor[] mn1 = ItemVendorFactory.showMenu();
    assertEquals(m1.hashCode(), mn1[0].hashCode());
  }
}
