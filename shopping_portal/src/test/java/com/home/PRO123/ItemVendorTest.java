package com.home.PRO123.model;

import com.home.PRO123.persistence.ItemVendorDAO;
import com.home.PRO123.factory.ItemVendorFactory;
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
 * Test class for ItemVendor.
 */
@RunWith(JMockit.class)
public class ItemVendorTest {
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
  public final void testItemVendor() {
    ItemVendor m = new ItemVendor();
    ItemVendor m1 = new ItemVendor(001, "abcdf", 7337672360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055");
    assertNotEquals(m1, null);
    assertEquals(m1.getItemVendorId(),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getItemVendorId());
    assertEquals(m1.getvendorName(),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getvendorName());
    assertEquals(m1.getvendorPhoneno(),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getvendorPhoneno());
    assertEquals(m1.getvendorEmailId(),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getvendorEmailId());
    assertEquals(m1.getpwd(),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getpwd());
    assertEquals(m1.setItemVendorId(001),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").setItemVendorId(001));
    assertEquals(m1.setvendorName("abcdf"),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").setvendorName("abcdf"));
    assertEquals(m1.setvendorPhoneno(7337662360L),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").setvendorPhoneno(7337662360L));
    assertEquals(m1.setvendorEmailId("abcdf2602@gmail.com"),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com",
         "81dc9bdb52d04dc20036dbd8313ed055").setvendorEmailId("abcdf2602@gmail.com"));
    assertEquals(m1.setpwd("81dc9bdb52d04dc20036dbd8313ed055"),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com",
         "81dc9bdb52d04dc20036dbd8313ed055").setpwd("81dc9bdb52d04dc20036dbd8313ed055"));
    assertEquals(m1.hashCode(),
        new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").hashCode());
    assertEquals(m1, new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055"));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final ItemVendorDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<ItemVendor>();
      }
    };
    new MockUp<ItemVendorFactory>() {
      @Mock
      ItemVendorDAO dao() {
        return dao;
      }
    };
    ItemVendor[] me = ItemVendorFactory.showMenu();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final ItemVendorDAO dao) {
    final ItemVendor m1 = new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055");
    final ArrayList<ItemVendor> mn = new ArrayList<ItemVendor>();
    new Expectations() {
      {
        mn.add(m1);
        dao.show(); result = mn;
      }
    };
    new MockUp<ItemVendorFactory>() {
      @Mock
      ItemVendorDAO dao() {
        return dao;
      }
    };
    ItemVendor[] mn1 = ItemVendorFactory.showMenu();
    assertEquals(1, mn1.length);
    assertEquals(new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getItemVendorId(),
        mn1[0].getItemVendorId());
    assertEquals(new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getvendorName(),
        mn1[0].getvendorName());
    assertEquals(new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getvendorPhoneno(),
        mn1[0].getvendorPhoneno());
    assertEquals(new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getvendorEmailId(),
        mn1[0].getvendorEmailId());
    assertEquals(new ItemVendor(001, "abcdf", 7337662360L, "abcdf2602@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055").getpwd(),
        mn1[0].getpwd());
  }
}
