package com.home.PRO123.model;

import com.home.PRO123.persistence.ItemDAO;
import com.home.PRO123.factory.ItemFactory;
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
 * Test class for Item.
 */
@RunWith(JMockit.class)
public class ItemTest {
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
  public final void testItem() {
    Item m = new Item();
    Item m1 = new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120);
    assertNotEquals(m1, null);
    assertEquals(m1.getitemId(),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getitemId());
    assertEquals(m1.getitemName(),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getitemName());
    assertEquals(m1.getitemType(),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getitemType());
    assertEquals(m1.getcuisine(),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getcuisine());
    assertEquals(m1.getavailability(),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getavailability());
    assertEquals(m1.getvendorId(),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getvendorId());
    assertEquals(m1.getitemCost(),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getitemCost());
    assertEquals(m1.setitemId(1),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).setitemId(1));
    assertEquals(m1.setitemName("noodles"),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).setitemName("noodles"));
    assertEquals(m1.setitemType("Food Item- Maggi"),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).setitemType("Food Item- Maggi"));
    assertEquals(m1.setavailability("yes"),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).setavailability("yes"));
    assertEquals(m1.setvendorId(001),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).setvendorId(001));
    assertEquals(m1.setitemCost(120),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).setitemCost(120));
    assertEquals(m1.hashCode(),
        new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).hashCode());
    assertEquals(m1, new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final ItemDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Item>();
      }
    };
    new MockUp<ItemFactory>() {
      @Mock
      ItemDAO dao() {
        return dao;
      }
    };
    Item[] me = ItemFactory.showItem();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final ItemDAO dao) {
    final Item m1 = new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120);
    final ArrayList<Item> mn = new ArrayList<Item>();
    new Expectations() {
      {
        mn.add(m1);
        dao.show(); result = mn;
      }
    };
    new MockUp<ItemFactory>() {
      @Mock
      ItemDAO dao() {
        return dao;
      }
    };
    Item[] mn1 = ItemFactory.showItem();
    assertEquals(1, mn1.length);
    assertEquals(new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getitemId(),
        mn1[0].getitemId());
    assertEquals(new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getitemName(),
        mn1[0].getitemName());
    assertEquals(new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getitemType(),
        mn1[0].getitemType());
    assertEquals(new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getavailability(),
        mn1[0].getavailability());
    assertEquals(new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getvendorId(),
        mn1[0].getvendorId());
    assertEquals(new Item(1, "noodles", "Food Item- Maggi", "yes", 001, 120).getitemCost(),
        mn1[0].getitemCost());
  }
}
