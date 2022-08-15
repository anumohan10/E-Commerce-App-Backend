package com.home.PRO123.model;
import java.util.Objects;


public class Cart {
/**
 * cartId to store cartId.
 */
  private int cartId;
  /**
 * custId to store custId.
 */
  private int custId;
  /**
 * ItemId to store ItemId.
 */
  private int ItemId;
  /**
 * vendorId to store vendorId.
 */
  private int vendorId;
  /**
 * quantity to store quantity.
 */
  private int quantity;
  /**
 * price to store price.
 */
  private int price;
  /**
   * Default Constructor.
   */
  public Cart() {

  }
/**
 * @param argcartId to initialize cartId.
 * @param argcustId to initialize custId.
 * @param argitemId to initialize ItemId.
 * @param argvendorId to initialize vendorId.
 * @param argquantity to initialize quantity.
 * @param argprice to initialize price.
 * used to get details through constructor.
 */

  public Cart(final int argcartId, final int argcustId, final int argitemId, final int argvendorId, final int argquantity, final int argprice) {
    this.cartId = argcartId;
    this.custId = argcustId;
    this.itemId = argitemId;
    this.vendorId = argvendorId;
    this.quantity = argquantity;
    this.price = argprice;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Cart cart = (Cart) obj;
    if (Objects.equals(cartId, cart.cartId) && Objects.equals(custId, cart.custId) && Objects.equals(ItemId, cart.ItemId)
          && Objects.equals(vendorId, cart.vendorId) && Objects.equals(quantity, cart.quantity) && Objects.equals(price, cart.price)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cartId, custId, itemId, vendorId, quantity, price);
  }
    /**
     * @return this cartId.
     */
  public final int getcartId() {
    return cartId;
  }
  /**
     * @return this custId.
     */
  public final int getcustId() {
    return custId;
  }
  /**
     * @return this ItemId.
     */
  public final int getItemId() {
    return ItemId;
  }
  /**
     * @return this quantity.
     */
  public final int getquantity() {
    return quantity;
  }
  /**
     * @return this price.
     */
  public final int getprice() {
    return price;
  }
    /**
     * @return this cartId.
     * @param argcartId to initialize cartId.
     */
  public final int setcartId(final int argcartId) {
    this.cartId = argcartId;
    return argcartId;
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
     * @return this ItemId.
     * @param argItemId to initialize ItemId.
     */
  public final int setItemId(final int argItemId) {
    this.ItemId = argItemId;
    return argItemId;
  }
  /**
     * @return this vendorId.
     * @param argvendorId to initialize ItemId.
     */
  public final int setvendorId(final int argvendorId) {
    this.vendorId = argvendorId;
    return argvendorId;
  }
  /**
     * @return this quantity.
     * @param argquantity to initialize quantity.
     */
  public final int setquantity(final int argquantity) {
    this.quantity = argquantity;
    return argquantity;
  }
  /**
     * @return this price.
     * @param argprice to initialize price.
     */
  public final int setprice(final int argprice) {
    this.price = argprice;
    return argprice;
  }
}
