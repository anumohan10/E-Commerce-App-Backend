package com.home.PRO123.model;

import com.home.PRO123.persistence.ReviewsDAO;
import com.home.PRO123.factory.ReviewsFactory;
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
 * Test class for Reviews.
 */
@RunWith(JMockit.class)
public class ReviewsTest {
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
  public final void testReviews() {
    Reviews m = new Reviews();
    Reviews m1 = new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles");
    assertNotEquals(m1, null);
    assertEquals(m1.getreviewsId(),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getreviewsId());
    assertEquals(m1.getcomments(),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getcomments());
    assertEquals(m1.getratings(),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getratings());
    assertEquals(m1.getcustId(),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getcustId());
    assertEquals(m1.getitemVendorId(),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getitemVendorId());
    assertEquals(m1.getitemId(),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getitemId());
    assertEquals(m1.getitemName(),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getitemName());
    assertEquals(m1.setreviewsId(1000),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").setreviewsId(1000));
    assertEquals(m1.setcomments("Good One"),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").setcomments("Good One"));
    assertEquals(m1.setratings(3),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").setratings(3));
    assertEquals(m1.setcustId(001),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").setcustId(001));
    assertEquals(m1.setitemVendorId(001),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").setitemVendorId(001));
    assertEquals(m1.setitemId(001),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").setitemId(001));
    assertEquals(m1.setitemName("Noodles"),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").setitemName("Noodles"));
    assertEquals(m1.hashCode(),
        new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").hashCode());
    assertEquals(m1, new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles"));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final ReviewsDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Reviews>();
      }
    };
    new MockUp<ReviewsFactory>() {
      @Mock
      ReviewsDAO dao() {
        return dao;
      }
    };
    Reviews[] me = ReviewsFactory.showReviews();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final ReviewsDAO dao) {
    final Reviews m1 = new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles");
    final ArrayList<Reviews> mn = new ArrayList<Reviews>();
    new Expectations() {
      {
        mn.add(m1);
        dao.show(); result = mn;
      }
    };
    new MockUp<ReviewsFactory>() {
      @Mock
      ReviewsDAO dao() {
        return dao;
      }
    };
    Reviews[] mn1 = ReviewsFactory.showReviews();
    assertEquals(1, mn1.length);
    assertEquals(new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getreviewsId(),
        mn1[0].getreviewsId());
    assertEquals(new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getcomments(),
        mn1[0].getcomments());
    assertEquals(new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getratings(),
        mn1[0].getratings());
    assertEquals(new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getcustId(),
        mn1[0].getcustId());
    assertEquals(new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getitemVendorId(),
        mn1[0].getitemVendorId());
    assertEquals(new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getitemId(),
        mn1[0].getitemId());
    assertEquals(new Reviews(1000, "Good One", 3, 001, 001, 001, "Noodles").getitemName(),
        mn1[0].getitemName());
  }
}
