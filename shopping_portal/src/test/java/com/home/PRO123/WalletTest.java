package com.home.PRO123.model;

import com.home.PRO123.persistence.WalletDAO;
import com.home.PRO123.factory.WalletFactory;
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
 * Test class for Wallet.
 */
@RunWith(JMockit.class)
public class WalletTest {
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
  public final void testWallet() {
    Wallet w = new Wallet();
    Wallet w1 = new Wallet(12346, 001, 2000, 5012457823L);
    assertNotEquals(w1, null);
    assertEquals(w1.getwalletId(),
        new Wallet(12346, 001, 2000, 5012457823L).getwalletId());
    assertEquals(w1.getcustId(),
        new Wallet(12346, 001, 2000, 5012457823L).getcustId());
    assertEquals(w1.getbalance(),
        new Wallet(12346, 001, 2000, 5012457823L).getbalance());
    assertEquals(w1.getbankaccNo(),
        new Wallet(12346, 001, 2000, 5012457823L).getbankaccNo());
    assertEquals(w1.setwalletId(12346),
        new Wallet(12346, 001, 2000, 5012457823L).setwalletId(12346));
    assertEquals(w1.setcustId(001),
        new Wallet(12346, 001, 2000, 5012457823L).setcustId(001));
    assertEquals(w1.setbalance(2000),
        new Wallet(12346, 001, 2000, 5012457823L).setbalance(2000));
    assertEquals(w1.setbankaccNo(5012457823L),
        new Wallet(12346, 001, 2000, 5012457823L).setbankaccNo(5012457823L));
    //assertNotEquals(w1, new Wallet(12346, 001, 2000, 5012457823L));
    assertEquals(w1.hashCode(),
        new Wallet(12346, 001, 2000, 5012457823L).hashCode());
    assertEquals(w1, new Wallet(12346, 001, 2000, 5012457823L));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final WalletDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Wallet>();
      }
    };
    new MockUp<WalletFactory>() {
      @Mock
      WalletDAO dao() {
        return dao;
      }
    };
    Wallet[] wt = WalletFactory.showWallet();
    assertEquals(0, wt.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final WalletDAO dao) {
    final Wallet w1 = new Wallet(12346, 001, 2000, 5012457823L);
    final ArrayList<Wallet> wl = new ArrayList<Wallet>();
    new Expectations() {
      {
        wl.add(w1);
        dao.show(); result = wl;
      }
    };
    new MockUp<WalletFactory>() {
      @Mock
      WalletDAO dao() {
        return dao;
      }
    };
    Wallet[] ws1 = WalletFactory.showWallet();
    assertEquals(1, ws1.length);
    assertEquals(new Wallet(12346, 001, 2000, 5012457823L).getwalletId(),
        ws1[0].getwalletId());
    assertEquals(new Wallet(12346, 001, 2000, 5012457823L).getcustId(),
        ws1[0].getcustId());
    assertEquals(new Wallet(12346, 001, 2000, 5012457823L).getbalance(),
        ws1[0].getbalance());
    assertEquals(new Wallet(12346, 001, 2000, 5012457823L).getbankaccNo(),
        ws1[0].getbankaccNo());
  }
}
