package com.home.PRO123.model;

import com.home.PRO123.persistence.CustomerDAO;
import com.home.PRO123.factory.CustomerFactory;
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
 * Test class for Customer.
 */
@RunWith(JMockit.class)
public class CustomerTest {
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
  public final void testCustomer() {
    Customer c = new Customer();
    Customer c1 = new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai");
    assertNotEquals(c1, null);
    assertEquals(c1.getcustId(),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustId());
    assertEquals(c1.getcustName(),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustName());
    assertEquals(c1.getcustPhno(),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustPhno());
    assertEquals(c1.getcustEmailid(),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustEmailid());
    assertEquals(c1.getpasswrd(),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getpasswrd());
    assertEquals(c1.getcustAddress(),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustAddress());
    assertEquals(c1.setcustId(001),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").setcustId(001));
    assertEquals(c1.setcustName("iopyrt"),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").setcustName("iopyrt"));
    assertEquals(c1.setcustPhno(90823654976),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").setcustPhno(90823654976));
    assertEquals(c1.setcustEmailid("iopyrtm@gmail.com"),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5",
         "Mumbai").setcustEmailid("iopyrtm@gmail.com"));
    assertEquals(c1.setpasswrd("9904fd42e4977d5815b5d5679a935ed5"),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5",
         "Mumbai").setpasswrd("9904fd42e4977d5815b5d5679a935ed5"));
    assertEquals(c1.setcustAddress("Mumbai"),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").setcustAddress("Mumbai"));
    //assertNotEquals(c1, new Customer(001, 'iopyrt',90823654976 'iopyrtm@gmail.com', '9904fd42e4977d5815b5d5679a935ed5', 'Mumbai'));
    assertEquals(c1.hashCode(),
        new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").hashCode());
    assertEquals(c1, new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai"));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Customer>();
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] ct = CustomerFactory.showMenu();
    assertEquals(0, ct.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final CustomerDAO dao) {
    final Customer c1 = new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai");
    final ArrayList<Customer> cs = new ArrayList<Customer>();
    new Expectations() {
      {
        cs.add(c1);
        dao.show(); result = cs;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] cs1 = CustomerFactory.showMenu();
    assertEquals(1, cs1.length);
    assertEquals(new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustId(),
        cs1[0].getcustId());
    assertEquals(new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustName(),
        cs1[0].getcustName());
    assertEquals(new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustPhno(),
        cs1[0].getcustPhno());
    assertEquals(new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustEmailid(),
        cs1[0].getcustEmailid());
    assertEquals(new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getpasswrd(),
        cs1[0].getpasswrd());
    assertEquals(new Customer(001, "iopyrt", 90823654976, "iopyrtm@gmail.com", "9904fd42e4977d5815b5d5679a935ed5", "Mumbai").getcustAddress(),
        cs1[0].getcustAddress());
  }
}
