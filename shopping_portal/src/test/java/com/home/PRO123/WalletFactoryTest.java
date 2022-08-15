package com.home.PRO123.model;

//import com.home.PRO123.persistence.MenuDAO;
import com.home.PRO123.factory.WalletFactory;
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
public class WalletFactoryTest {
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
  public final void testWalletFactory() {
    //final WalletFactoryTest w1 = new WalletFactoryTest();
    final Wallet w1 = new Wallet(12346, 001, 2000, 5012457823L);
    Wallet[] ws1 = WalletFactory.showWallet();
    assertEquals(w1.hashCode(), ws1[0].hashCode());
  }
}
