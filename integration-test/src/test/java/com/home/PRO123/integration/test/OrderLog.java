package com.home.PRO123.integration.test;
import java.util.Objects;
import com.home.PRO123.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class OrderLog {
/**
 * orderId to store orderId.
 */
  private int orderId;
  /**
 * custId to store custId.
 */
  private int custId;
  /**
 * itemId to store itemId.
 */
  private int itemId;
  /**
 * itemName to store itemName.
 */
  private String itemName;
  /**
 * availability to store availability.
 */
  private int vendorId;
  /**
 * itemId to store totalCost.
 */
  private int totalCost;
  /**
 * orderDate to store orderDate.
 */
  private String orderDate;
  /**
   * Default Constructor.
   */
  public OrderLog() {

  }
/**
 * @param argorderId to initialize order id.
 * @param argcustId to initialize customer id.
 * @param argitemId to initialize item id.
 * @param argitemName to initialize itemName.
 * @param argvendorId to initialize vendor id.
 * @param argtotalCost to initialize cost.
 * @param argorderDate to initialize item cost.
 * used to get details through constructor.
 */

  public OrderLog(final int argorderId, final int argcustId, final int argitemId, final String argitemName,
      final int argvendorId, final int argtotalCost, final String argorderDate) {
    this.orderId = argorderId;
    this.custId = argcustId;
    this.itemId = argitemId;
    this.itemName = argitemName;
    this.vendorId = argvendorId;
    this.totalCost = argtotalCost;
    this.orderDate = argorderDate;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    OrderLog order = (OrderLog) obj;
    if (Objects.equals(orderId, order.orderId) && Objects.equals(custId, order.custId) && Objects.equals(itemId, order.itemId)
          && Objects.equals(itemName, order.itemName)
          && Objects.equals(vendorId, order.vendorId) && Objects.equals(totalCost, order.totalCost) && Objects.equals(orderDate, order.orderDate)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(orderId, custId, itemId, itemName, vendorId, totalCost, orderDate);
  }
    /**
     * @return this item ID.
     */
  public final int getorderId() {
    return orderId;
  }
  /**
     * @return this item name.
     */
  public final int getcustId() {
    return custId;
  }
  /**
     * @return this item type.
     */
  public final int getitemId() {
    return itemId;
  }
  /**
     * @return this itemName.
     */
  public final String getitemName() {
    return itemName;
  }
  /**
     * @return this vendor ID.
     */
  public final int getvendorId() {
    return vendorId;
  }
  /**
     * @return this totalCost.
     */
  public final int gettotalCost() {
    return totalCost;
  }
  /**
     * @return this item cost.
     */
  public final String getorderDate() {
    return orderDate;
  }
    /**
     * @param argorderId to initialize item id.
     * @return the value.
     */
  public final int setorderId(final int argorderId) {
    this.orderId = argorderId;
    return argorderId;
  }
  /**
     * @param argcustId to initialize item name.
     * @return the value.
     */
  public final int setcustId(final int argcustId) {
    this.custId = argcustId;
    return argcustId;
  }
  /**
     * @param argitemId to initialize item type.
     * @return the value.
     */
  public final int setitemId(final int argitemId) {
    this.itemId = argitemId;
    return argitemId;
  }
  /**
     * @param argitemName to initialize itemName.
     * @return the value.
     */
  public final String setitemName(final String argitemName) {
    this.itemName = argitemName;
    return argitemName;
  }
  /**
     * @param argvendorId to initialize vendor id.
     * @return the value.
     */
  public final int setvendorId(final int argvendorId) {
    this.vendorId = argvendorId;
    return argvendorId;
  }
  /**
     * @param argtotalCost to initialize totalCost.
     * @return the value.
     */
  public final int settotalCost(final int argtotalCost) {
    this.totalCost = argtotalCost;
    return argtotalCost;
  }
  /**
     * @param argorderDate to initialize item cost.
     * @return the value.
     */
  public final String setorderDate(final String argorderDate) {
    this.orderDate = argorderDate;
    return argorderDate;
  }
}
