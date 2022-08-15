package com.home.PRO123.model;

//import com.home.PRO123.persistence.MenuDAO;
import com.home.PRO123.factory.CustomerFactory;
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
 * Test class for Customer.
 */
@RunWith(JMockit.class)
public class CustomerFactoryTest {
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
  public final void testCustomerFactory() {
    //final CustomerFactoryTest c1 = new CustomerFactoryTest();
    final Customer c1 = new Customer(001, "iopyrt", 90823654976L, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai");
    Customer[] cs1 = CustomerFactory.showMenu();
    assertEquals(c1.hashCode(), cs1[0].hashCode());
  }
}
