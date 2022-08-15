package com.home.PRO123.model;
import java.util.Objects;


public class Item {
/**
 * itemId to store itemId.
 */
  private int itemId;
  /**
 * itemName to store itemName.
 */
  private String itemName;
  /**
 * itemType to store itemType.
 */
  private String itemType;
  /**
  /**
 * availability to store availability.
 */
  private String availability;
  /**
 * vendorId to store vendorId.
 */
  private int vendorId;
  /**
 * itemCost to store itemCost.
 */
  private int itemCost;
  /**
   * Default Constructor.
   */
  public Menu() {

  }
/**
 * @param argitemId to initialize item id.
 * @param argitemName to initialize item name.
 * @param argitemType to initialize item type.
 * @param argavailability to initialize availability.
 * @param argvendorId to initialize vendor id.
 * @param argitemCost to initialize item cost.
 * used to get details through constructor.
 */

  public Menu(final int argitemId, final String argitemName, final String argitemType, final String argavailability,
    final int argvendorId, final int argitemCost) {
    this.itemId = argitemId;
    this.itemName = argitemName;
    this.itemType = argitemType;
    this.availability = argavailability;
    this.vendorId = argvendorId;
    this.itemCost = argitemCost;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(itemId, menu.itemId) && Objects.equals(itemName, menu.itemName) && Objects.equals(itemType, menu.itemType)
          && Objects.equals(availability, menu.availability) && Objects.equals(vendorId, menu.vendorId)
          && Objects.equals(itemCost, menu.itemCost)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(itemId, itemName, itemType, availability, vendorId, itemCost);
  }
    /**
     * @return this item ID.
     */
  public final int getitemId() {
    return itemId;
  }
  /**
     * @return this item name.
     */
  public final String getitemName() {
    return itemName;
  }
  /**
     * @return this item type.
     */
  public final String getitemType() {
    return itemType;
  }
  /**
     * @return this availability.
     */
  public final String getavailability() {
    return availability;
  }
  /**
     * @return this vendor ID.
     */
  public final int getvendorId() {
    return vendorId;
  }
  /**
     * @return this item cost.
     */
  public final int getitemCost() {
    return itemCost;
  }
    /**
     * @return this item id.
     * @param argitemId to initialize item id.
     */
  public final int setitemId(final int argitemId) {
    this.itemId = argitemId;
    return argitemId;
  }
  /**
     * @return this item name.
     * @param argitemName to initialize item name.
     */
  public final String setitemName(final String argitemName) {
    this.itemName = argitemName;
    return argitemName;
  }
  /**
     * @return this item type.
     * @param argitemType to initialize item type.
     */
  public final String setitemType(final String argitemType) {
    this.itemType = argitemType;
    return argitemType;
  }
  /**
     * @return availability.
     * @param argavailability to initialize availability.
     */
  public final String setavailability(final String argavailability) {
    this.availability = argavailability;
    return argavailability;
  }
  /**
     * @return vendor id.
     * @param argvendorId to initialize vendor id.
     */
  public final int setvendorId(final int argvendorId) {
    this.vendorId = argvendorId;
    return argvendorId;
  }
  /**
     * @return item cost.
     * @param argitemCost to initialize item cost.
     */
  public final int setitemCost(final int argitemCost) {
    this.itemCost = argitemCost;
    return argitemCost;
  }
}
