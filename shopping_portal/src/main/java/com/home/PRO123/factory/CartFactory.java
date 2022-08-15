package com.hexaware.MLP290.factory;

import com.hexaware.MLP290.persistence.CartDAO;
import com.hexaware.MLP290.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP290.model.Cart;
/**
 * CartFactory class used to fetch data from database.
 */
public class CartFactory {
  /**
   *  Protected constructor.
   */
  protected CartFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CartDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CartDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of coupon object.
   * @param cartId to initialize coupon id.
   * @param custId to initialize coupon code.
   * @param foodId to initialize customer id.
   * @param vendorId to initialize order id.
   * @param quantity to initialize quantity.
   * @param price to initialize price.
   */

  public static String update(final int cartId, final int custId, final int foodId, final int vendorId,
      final int quantity, final int price) {
    dao().insert(cartId, custId, foodId, vendorId, quantity, price);
    return "Item Added Successfully!!";
  }
  /**
   * Call the data base connection.
   * @return the array of Cart object.
   */
  public static Cart[] showCart() {
    List<Cart> cart = dao().show();
    return cart.toArray(new Cart[cart.size()]);
  }
}
