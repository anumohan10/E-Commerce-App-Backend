package com.home.PRO123.factory;

import com.home.PRO123.persistence.OrderLogDAO;
import com.home.PRO123.persistence.DbConnection;
import java.util.List;

import com.home.PRO123.model.OrderLog;

public class OrderLogFactory {
  /**
   *  Protected constructor.
   */
  protected OrderLogFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrderLogDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderLogDAO.class);
  }
  /**
   * call the database connection.
   * @return the order status.
   * @param orderId for storing order Id.
   * @param custId for storing Customer Id.
   * @param itemId for storing itemId.
   * @param itemName for storing item Name.
   * @param vendorId for storing vendorId.
   * @param totalCost for storing totalCost.
   */
  public static String placeOrder(final int orderId, final int custId, final int itemId, final String itemName,
      final int vendorId, final int totalCost) {
    dao().insert(orderId, custId, itemId, itemName, vendorId, totalCost);
    return "Order Placed";
  }
  /**
   * fetch orders only for required customer.
   * @return the connection object.
   */
  public static OrderLog[] showOrderLog() {
    List<OrderLog> order = dao().show();
    return order.toArray(new OrderLog[order.size()]);
  }
  /**
   * fetch orders only for required customer.
   * @param id to pass id.
   * @return the connection object.
   */
  public static OrderLog[] showbyorderlogId(final int id) {
    List<OrderLog> order = dao().showbyid(id);
    return order.toArray(new OrderLog[order.size()]);
  }
  /**
   * fetch orders only for required customer.
   * @param cid to pass cust id.
   * @return the connection object.
   */
  public static OrderLog[] showbycustId(final int cid) {
    List<OrderLog> order = dao().showbycustid(cid);
    return order.toArray(new OrderLog[order.size()]);
  }
  /**
   * fetch orders only for required customer.
   * @param vid to pass vendor id.
   * @return the connection object.
   */
  public static OrderLog[] showbyvendorId(final int vid) {
    List<OrderLog> order = dao().showbyvendorid(vid);
    return order.toArray(new OrderLog[order.size()]);
  }
  /**
   * fetch orders only for required customer.
   * @param cid to pass cust id.
   * @return the connection object.
   */
  public static OrderLog[] showbycustIdRecent(final int cid) {
    List<OrderLog> order = dao().showbycustidRecent(cid);
    return order.toArray(new OrderLog[order.size()]);
  }
  /**
   * fetch orders only for required customer.
   * @param vid to pass cust id.
   * @return the connection object.
   */
  public static OrderLog[] showbyvendorIdRecent(final int vid) {
    List<OrderLog> order = dao().showbyvendoridRecent(vid);
    return order.toArray(new OrderLog[order.size()]);
  }
}
