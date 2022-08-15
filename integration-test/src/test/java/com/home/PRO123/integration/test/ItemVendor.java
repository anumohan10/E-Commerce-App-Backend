package com.home.PRO123.integration.test;
import java.util.Objects;
import com.hexaware.MLP290.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class ItemVendor {
/**
 * ItemVendorId to store ItemVendorId.
 */
  private int ItemVendorId;
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
  public ItemVendor() {

  }
/**
 * @param argItemVendorId to initialize ItemVendorId.
 * @param argvendorName to initialize vendorName.
 * @param argvendorPhoneno to initialize vendorPhoneno.
 * @param argvendorEmailId to initialize vendorEmailId.
 * @param argpwd to initialize pwd.
 * used to get details through constructor.
 */

  public ItemVendor(final int argItemVendorId, final String argvendorName, final long argvendorPhoneno, final String argvendorEmailId,
        final String argpwd) {
    this.ItemVendorId = argItemVendorId;
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
    ItemVendor Itemvendor = (ItemVendor) obj;
    if (Objects.equals(ItemVendorId, Itemvendor.ItemVendorId) && Objects.equals(vendorName, Itemvendor.vendorName)
          && Objects.equals(vendorPhoneno, Itemvendor.vendorPhoneno) && Objects.equals(vendorEmailId, Itemvendor.vendorEmailId)
           && Objects.equals(pwd, Itemvendor.pwd)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(ItemVendorId, vendorName, vendorPhoneno, vendorEmailId, pwd);
  }
    /**
     * @return this ItemVendorId.
     */
  public final int getItemVendorId() {
    return ItemVendorId;
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
     * @return this ItemVendorId.
     * @param argItemVendorId to initialize ItemVendorId.
     */
  public final int setItemVendorId(final int argItemVendorId) {
    this.ItemVendorId = argItemVendorId;
    return argItemVendorId;
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
