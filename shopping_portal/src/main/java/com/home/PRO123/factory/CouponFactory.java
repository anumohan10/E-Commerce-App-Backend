package com.home.PRO123.factory;

import com.home.PRO123.persistence.CouponDAO;
import com.home.PRO123.persistence.DbConnection;
import java.util.List;

import com.home.PRO123.model.Coupon;

public class CouponFactory {
  /**
   *  Protected constructor.
   */
  protected CouponFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CouponDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CouponDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of coupon object.
   * @param cpnId to initialize coupon id.
   * @param cpnCode to initialize coupon code.
   * @param cstId to initialize customer id.
   * @param ordrId to initialize order id.
   */

  public static String updatedCoupon(final int cpnId, final String cpnCode, final int cstId, final int ordrId) {
    dao().insert(cpnId, cpnCode, cstId, ordrId);
    return "Coupon Added Successfully!!";
  }
  /**
   * @param cpnCode to initialize coupon code.
   * @param cpnId to initialize coupon id.
   * @return to return updated details.
   */
  public static String couponcodeUpdate(final String cpnCode, final int cpnId) {
    dao().updateCpncd(cpnCode, cpnId);
    return "Coupon Code updated successfully!";
  }
  /**
   * Call the data base connection.
   * @return the array of coupon object.
   */
  public static Coupon[] showMenu() {
    List<Coupon> coupon = dao().show();
    return coupon.toArray(new Coupon[coupon.size()]);
  }
}
