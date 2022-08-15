package com.home.PRO123.model;
import java.util.Objects;

public class ItemVendor {
/**
 * itemVendorId to store itemVendorId.
 */
  private int itemVendorId;
  /**
 * vendorName to store vendorName.
 */
  private String vendorName;
  /**
 * vendorPhoneno to store vendorPhoneno.
 */
  private long vendorPhoneno;
  /**
 * vendorEmailId to store vendorEmailId.
 */
  private String vendorEmailId;
  /**
 * pwd to store pwd.
 */
  private String pwd;
  /**
   * Default Constructor.
   */
  public itemVendor() {

  }
/**
 * @param argitemVendorId to initialize itemVendorId.
 * @param argvendorName to initialize vendorName.
 * @param argvendorPhoneno to initialize vendorPhoneno.
 * @param argvendorEmailId to initialize vendorEmailId.
 * @param argpwd to initialize pwd.
 * used to get details through constructor.
 */

  public itemVendor(final int argitemVendorId, final String argvendorName, final long argvendorPhoneno, final String argvendorEmailId,
        final String argpwd) {
    this.itemVendorId = argitemVendorId;
    this.vendorName = argvendorName;
    this.vendorPhoneno = argvendorPhoneno;
    this.vendorEmailId = argvendorEmailId;

    this.pwd = argpwd;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    itemVendor itemvendor = (itemVendor) obj;
    if (Objects.equals(itemVendorId, itemvendor.itemVendorId) && Objects.equals(vendorName, itemvendor.vendorName)
          && Objects.equals(vendorPhoneno, itemvendor.vendorPhoneno) && Objects.equals(vendorEmailId, itemvendor.vendorEmailId)
           && Objects.equals(pwd, itemvendor.pwd)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(itemVendorId, vendorName, vendorPhoneno, vendorEmailId, pwd);
  }
    /**
     * @return this itemVendorId.
     */
  public final int getitemVendorId() {
    return itemVendorId;
  }
  /**
     * @return this vendorName.
     */
  public final String getvendorName() {
    return vendorName;
  }
  /**
     * @return this vendorPhoneno.
     */
  public final long getvendorPhoneno() {
    return vendorPhoneno;
  }
  /**
     * @return this vendorEmailId.
     */
  public final String getvendorEmailId() {
    return vendorEmailId;
  }
  /**
     * @return this pwd.
     */
  public final String getpwd() {
    return pwd;
  }
  /**
     * @return this itemVendorId.
     * @param argitemVendorId to initialize itemVendorId.
     */
  public final int setitemVendorId(final int argitemVendorId) {
    this.itemVendorId = argitemVendorId;
    return argitemVendorId;
  }
  /**
     * @return this vendorName.
     * @param argvendorName to initialize vendorName.
     */
  public final String setvendorName(final String argvendorName) {
    this.vendorName = argvendorName;
    return argvendorName;
  }
  /**
     * @return this vendorPhoneno.
     * @param argvendorPhoneno to initialize vendorPhoneno.
     */
  public final long setvendorPhoneno(final long argvendorPhoneno) {
    this.vendorPhoneno = argvendorPhoneno;
    return argvendorPhoneno;
  }
  /**
    * @return this vendorEmailId.
     * @param argvendorEmailId to initialize vendorEmailId.
     */
  public final String setvendorEmailId(final String argvendorEmailId) {
    this.vendorEmailId = argvendorEmailId;
    return argvendorEmailId;
  }
 /**
     * @return this pwd.
     * @param argpwd to initialize pwd.
     */
  public final String setpwd(final String argpwd) {
    this.pwd = argpwd;
    return argpwd;
  }
}
