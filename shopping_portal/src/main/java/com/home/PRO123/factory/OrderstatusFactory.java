package com.home.PRO123.factory;

import com.home.PRO123.persistence.OrderstatusDAO;
import com.home.PRO123.persistence.DbConnection;
import java.util.List;

import com.home.PRO123.model.Orderstatus;

public class OrderstatusFactory {
  /**
   *  Protected constructor.
   */
  protected OrderstatusFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrderstatusDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderstatusDAO.class);
  }
  /**
   * call the database connection.
   * @return the order status.
   * @param id to initialize Orderstatus id.
   * @param orderId to initialize order id.
   * @param vendorid to initialize foodVentorId.
   * @param custId to initialize custId.
   * @param qty to initialize quantity.
   */
  public static String placeOrder(final int id, final int orderId, final int vendorid, final int custId, final int qty) {
    dao().insert(id, orderId, vendorid, custId, qty);
    return "Order Placed";
  }
  /**
   * call the database connection.
   * @return the order status.
   * @param orderId to initialize order id.
   */
  public static String cancelOrder(final int orderId) {
    dao().cancel(orderId);
    return "Order Cancelled !";
  }
    /**
   * call the database connection.
   * @return the order status.
   * @param orderId to initialize order id.
   * @param eta to pass eta.
   * @param orderstatus to pass orderstatus.
   */
  public static String updateOrder(final int orderId, final String eta, final String orderstatus) {
    dao().update(orderId, eta, orderstatus);
    return "Order Updated !";
  }
  /**
   * Call the data base connection.
   * @return the array of Orderstatus object.
   */
  public static Orderstatus[] showOrderstatus() {
    List<Orderstatus> order = dao().show();
    return order.toArray(new Orderstatus[order.size()]);
  }
  /**
   * Call the data base connection.
   * @param id to pass id.
   * @return the array of Orderstatus object.
   */
  public static Orderstatus[] showbyOrderstatusId(final int id) {
    List<Orderstatus> order = dao().showbyid(id);
    return order.toArray(new Orderstatus[order.size()]);
  }
  /**
   * Call the data base connection.
   * @param cid to pass id.
   * @return the array of Orderstatus object.
   */
  public static Orderstatus[] showbycustId(final int cid) {
    List<Orderstatus> order = dao().showbycustid(cid);
    return order.toArray(new Orderstatus[order.size()]);
  }
  /**
   * Call the data base connection.
   * @param vid to pass id.
   * @return the array of Orderstatus object.
   */
  public static Orderstatus[] showbyvendorId(final int vid) {
    List<Orderstatus> order = dao().showbyvendorid(vid);
    return order.toArray(new Orderstatus[order.size()]);
  }
  /**
   * Call the data base connection.
   * @param cid to pass id.
   * @return the array of Orderstatus object.
   */
  public static Orderstatus[] showbycustIdRecent(final int cid) {
    List<Orderstatus> order = dao().showbycustidRecent(cid);
    return order.toArray(new Orderstatus[order.size()]);
  }
  /**
   * Call the data base connection.
   * @param vid to pass id.
   * @return the array of Orderstatus object.
   */
  public static Orderstatus[] showbyvendorIdRecent(final int vid) {
    List<Orderstatus> order = dao().showbyvendoridRecent(vid);
    return order.toArray(new Orderstatus[order.size()]);
  }
}
