package com.home.PRO123.integration.test;
import java.util.Objects;
import com.home.PRO123.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


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
  public Item() {

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

  public Item(final int argitemId, final String argitemName, final String argitemType,
       final String argavailability, final int argvendorId, final int argitemCost) {
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
    Item Item = (Item) obj;
    if (Objects.equals(itemId, Item.itemId) && Objects.equals(itemName, Item.itemName) && Objects.equals(itemType, Item.itemType)
          && Objects.equals(cuisine, Item.cuisine) && Objects.equals(availability, Item.availability)
          && Objects.equals(vendorId, Item.vendorId) && Objects.equals(itemCost, Item.itemCost)) {
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
