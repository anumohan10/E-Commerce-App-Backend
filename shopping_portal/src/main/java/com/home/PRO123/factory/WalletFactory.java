package com.home.PRO123.factory;

import com.home.PRO123.persistence.WalletDAO;
import com.home.PRO123.persistence.DbConnection;
import java.util.List;

import com.home.PRO123.model.Wallet;

public class WalletFactory {
  /**
   *  Protected constructor.
   */
  protected WalletFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static WalletDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(WalletDAO.class);
  }
  /**
   * call the database connection.
   * @return the order status.
   * @param balance for storing balance.
   * @param custId for storing Customer Id.
   */
  public static String order(final int custId, final int balance) {
    dao().order(custId, balance);
    return "Balance Updated";
  }
  /**
   * call the database connection.
   * @return the order status.
   * @param balance for storing balance.
   * @param custId for storing Customer Id.
   */
  public static String refund(final int custId, final int balance) {
    dao().refund(custId, balance);
    return "Balance Updated";
  }
  /**
   * call the database connection.
   * @return the order status.
   * @param walletid for storing balance.
   * @param custId for storing Customer Id.
   */
  public static String addUser(final int walletid, final int custId) {
    dao().insert(walletid, custId);
    return "User added";
  }
  /**
   * call the database connection.
   * @return the order status.
   * @param bank for storing account no.
   * @param custId for storing Customer Id.
   */
  public static String updateBank(final long bank, final int custId) {
    dao().updateBank(bank, custId);
    return "Bank Details Updated";
  }
  /**
   * Call the data base connection.
   * @return the array of Wallet object.
   */
  public static Wallet[] showWallet() {
    List<Wallet> order = dao().show();
    return order.toArray(new Wallet[order.size()]);
  }
  /**
   * Call the data base connection.
   * @param walletid to display wallet.
   * @return the array of Wallet object.
   */
  public static Wallet[] showbywalletId(final int walletid) {
    List<Wallet> order = dao().show(walletid);
    return order.toArray(new Wallet[order.size()]);
  }
}
