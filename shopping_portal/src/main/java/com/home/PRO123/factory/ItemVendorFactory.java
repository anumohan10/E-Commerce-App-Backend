package com.home.PRO123.factory;

import com.home.PRO123.persistence.ItemVendorDAO;
import com.home.PRO123.persistence.DbConnection;
import java.util.List;

import com.home.PRO123.model.ItemVendor;

public class ItemVendorFactory {
  /**
   *  Protected constructor.
   */
  protected ItemVendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static ItemVendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(ItemVendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Itemvendor object.
   * @param itId to initialize ItemVendorID.
   * @param itName to initialize VendorName.
   * @param phNo to initialize VendorPhoneno.
   * @param emailId to initialize VendorEmailID.
   * @param pwd to initialize Pwd.
   */
  public static String signup(final int itId, final String itName, final long phNo, final String emailId, final String pwd) {
    dao().vendorSignup(itId, itName, phNo, emailId, pwd);
    return "Successful Sign Up";
  }
  /**
   * @return the connection object.
   * call the data base connection.
   * @param emailId to initialize VendorEmailId.
   * @param pwd to initialize Pwd.
   */
  public static ItemVendor[] loginItemvendor(final String emailId, final String pwd) {
    List<ItemVendor> Itemvendor = dao().show(emailId, pwd);
    return Itemvendor.toArray(new ItemVendor[Itemvendor.size()]);
  }
  /**
   * @return the connection object.
   * call the data base connection.
   * @param phNo to initialize VendorPhoneno.
   * @param emailId to initialize ItemVendorID.
   */
  public static String phupdate(final long phNo, final String emailId) {
    dao().updatephNo(phNo, emailId);
    return "Phone Number updated successfully";
  }
   /**
   * @return the connection object.
   * call the data base connection.
   * @param emailId to initialize VendorEmailId.
   * @param phNo to initialize VendorPhoneno.
   */
  public static String eiupdate(final String emailId, final long phNo) {
    dao().updateEid(emailId, phNo);
    return "Email Id updated successfully";
  }
   /**
   * @return the connection object.
   * call the data base connection.
   * @param pwd to initialize Pwd.
   * @param phNo to initialize VendorPhoneno.
   */
  public static String pwdupdate(final String pwd, final long phNo) {
    dao().updatepwd(pwd, phNo);
    return "Password updated successfully";
  }
   /**
   * @return the connection object.
   * call the data base connection.
   * @param emailId to initialize VendorEmailId.
   * @param pwd to initialize Pwd.
   */
  public static String pwdforpass(final String pwd, final String emailId) {
    dao().updateforpass(pwd, emailId);
    return "Password updated successfully";
  }
   /**
   * @return the connection object.
   * call the data base connection.
   * @param emailId to initialize VendorEmailId.
   * @param pwd to initialize Pwd.
   */
  public static String accdelete(final String emailId, final String pwd) {
    dao().deleteAcc(emailId, pwd);
    return "Your Account has been deleted";
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  public static ItemVendor[] showMenu() {
    List<ItemVendor> Itemvendor = dao().show();
    return Itemvendor.toArray(new ItemVendor[Itemvendor.size()]);
  }
}
