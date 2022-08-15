package com.home.PRO123.model;

//import com.home.PRO123.persistence.MenuDAO;
import com.home.PRO123.factory.ReviewsFactory;
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
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class ReviewsFactoryTest {
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
  public final void testReviewsFactory() {
    //final MenuFactoryTest m1 = new MenuFactoryTest();
    final Reviews m1 = new Reviews(1000, "Good One", 3, 1, 1, 1, "Noodles");
    Reviews[] mn1 = ReviewsFactory.showReviews();
    assertEquals(m1.hashCode(), mn1[0].hashCode());
  }
}
