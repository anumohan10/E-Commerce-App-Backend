package com.home.PRO123.model;
import java.util.Objects;

public class Coupon {
/**
 * couponId to store couponId.
 */
  private int couponId;
  /**
 * couponCode to store couponCode.
 */
  private String couponCode;
  /**
 * custId to store custId.
 */
  private int custId;
  /**
 * orderId to store orderId.
 */
  private int orderId;
  /**
   * Default Constructor.
   */
  public Coupon() {

  }
/**
 * @param argcouponId to initialize couponId.
 * @param argcouponCode to initialize couponCode.
 * @param argcustId to initialize custId.
 * @param argorderId to initialize orderId.
 * used to get details through constructor.
 */

  public Coupon(final int argcouponId, final String argcouponCode, final int argcustId, final int argorderId) {
    this.couponId = argcouponId;
    this.couponCode = argcouponCode;
    this.custId = argcustId;
    this.orderId = argorderId;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Coupon coupon = (Coupon) obj;
    if (Objects.equals(couponId, coupon.couponId) && Objects.equals(couponCode, coupon.couponCode) && Objects.equals(custId, coupon.custId)
          && Objects.equals(orderId, coupon.orderId)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(couponId, couponCode, custId, orderId);
  }
    /**
     * @return this couponId.
     */
  public final int getcouponId() {
    return couponId;
  }
  /**
     * @return this couponCode.
     */
  public final String getcouponCode() {
    return couponCode;
  }
  /**
     * @return this custId.
     */
  public final int getcustId() {
    return custId;
  }
  /**
     * @return this orderId.
     */
  public final int getorderId() {
    return orderId;
  }
    /**
     * @return this couponId.
     * @param argcouponId to initialize couponId.
     */
  public final int setcouponId(final int argcouponId) {
    this.couponId = argcouponId;
    return argcouponId;
  }
  /**
     * @return this couponCode.
     * @param argcouponCode to initialize couponCode.
     */
  public final String setcouponCode(final String argcouponCode) {
    this.couponCode = argcouponCode;
    return argcouponCode;
  }
  /**
     * @return this custId.
     * @param argcustId to initialize custId.
     */
  public final int setcustId(final int argcustId) {
    this.custId = argcustId;
    return argcustId;
  }
  /**
     * @return this orderId.
     * @param argorderId to initialize orderId.
     */
  public final int setorderId(final int argorderId) {
    this.orderId = argorderId;
    return argorderId;
  }
}
