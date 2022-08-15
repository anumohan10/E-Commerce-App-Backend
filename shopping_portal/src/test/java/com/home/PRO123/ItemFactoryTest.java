package com.home.PRO123.model;

//import com.home.PRO123.persistence.ItemDAO;
import com.home.PRO123.factory.ItemFactory;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
//import com.home.PRO123.persistence.DbConnection;

//import mockit.Expectations;
//import mockit.MockUp;
//import mockit.Mocked;
//import mockit.Mock;
import mockit.integration.junit4.JMockit;
//import java.util.ArrayList;

/**
 * Test class for Item.
 */
@RunWith(JMockit.class)
public class ItemFactoryTest {
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
  public final void testItemFactory() {
    //final ItemFactoryTest m1 = new ItemFactoryTest();
    final Item m1 = new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120);
    Item[] mn1 = ItemFactory.showItem();
    assertEquals(m1.hashCode(), mn1[0].hashCode());
  }
}
