package com.home.PRO123.integration.test;
import java.util.Objects;
import com.home.PRO123.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class Orderstatus {
/**
 * Orderstatus id to store Orderstatus id.
 */
  private int id;
  /**
 * order id to store order id.
 */
  private int orderId;
  /**
 * eta to store eta.
 */
  private String eta;
  /**
 * orderstatus to store orderstatus.
 */
  private String orderstatus;
  /**
 * itemVendorId to store itemVendorId.
 */
  private int itemVendorId;
  /**
 * custId to store custId.
 */
  private int custId;
  /**
 * itemVendorId to store itemVendorId.
 */
  private int quantity;
  /**
   * Default Constructor.
   */
  public Orderstatus() {

  }
/**
 * @param argid to initialize Orderstatus id.
 * @param argorderId to initialize order id.
 * @param argeta to initialize eta.
 * @param argorderstatus to initialize orderstatus.
 * @param argitemVendorId to initialize itemVendorId.
 * @param argcustId to initialize custId.
 * @param argquantity to initialize quantity.
 * used to get details through constructor.
 */
  public Orderstatus(final int argid, final int argorderId, final String argeta, final String argorderstatus, final int argitemVendorId,
      final int argcustId, final int argquantity) {
    this.id = argid;
    this.orderId = argorderId;
    this.eta = argeta;
    this.orderstatus = argorderstatus;
    this.itemVendorId = argitemVendorId;
    this.custId = argcustId;
    this.quantity = argquantity;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orderstatus os = (Orderstatus) obj;
    if (Objects.equals(id, os.id) && Objects.equals(orderId, os.orderId) && Objects.equals(eta, os.eta) && Objects.equals(orderstatus, os.orderstatus)
        && Objects.equals(itemVendorId, os.itemVendorId) && Objects.equals(custId, os.custId) && Objects.equals(quantity, os.quantity)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(id, orderId, eta, orderstatus, itemVendorId, custId, quantity);
  }
    /**
     * @return Orderstatus id.
     */
  public final int getid() {
    return id;
  }
  /**
     * @return this order id.
     */
  public final int getorderId() {
    return orderId;
  }
  /**
     * @return this eta.
     */
  public final String geteta() {
    return eta;
  }
  /**
     * @return this orderstatus.
     */
  public final String getorderstatus() {
    return orderstatus;
  }
  /**
     * @return this itemVendorId.
     */
  public final int getitemVendorId() {
    return itemVendorId;
  }
  /**
     * @return this itemVendorId.
     */
  public final int getcustId() {
    return custId;
  }
  /**
     * @return this itemVendorId.
     */
  public final int getquantity() {
    return quantity;
  }
    /**
     * @param argid to initialize Orderstatus id.
     * @return to return value.
     */
  public final int setid(final int argid) {
    this.id = argid;
    return argid;
  }
  /**
     * @param argorderId to initialize order id.
     * @return to return value.
     */
  public final int setorderId(final int argorderId) {
    this.orderId = argorderId;
    return argorderId;
  }
  /**
     * @param argeta to initialize eta.
     * @return to return value.
     */
  public final String seteta(final String argeta) {
    this.eta = argeta;
    return argeta;
  }
  /**
     * @param argorderstatus to initialize orderstatus.
     * @return to return value.
     */
  public final String setorderstatus(final String argorderstatus) {
    this.orderstatus = argorderstatus;
    return argorderstatus;
  }
  /**
     * @param argitemVendorId to initialize itemVendorId.
     * @return to return value.
     */
  public final int setitemVendorId(final int argitemVendorId) {
    this.itemVendorId = argitemVendorId;
    return argitemVendorId;
  }
  /**
     * @param argcustId to initialize custId.
     * @return to return value.
     */
  public final int setcustId(final int argcustId) {
    this.custId = argcustId;
    return argcustId;
  }
  /**
     * @param argquantity to initialize quantity.
     * @return to return value.
     */
  public final int setquantity(final int argquantity) {
    this.quantity = argquantity;
    return argquantity;
  }
}
