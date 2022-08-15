package com.home.PRO123.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.model.itemVendor;
import com.home.PRO123.factory.itemVendorFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/itemvendor")
public class itemVendorRest {
  /**
   * Returns itemVendor details.
   * @return the itemvendor details
   */
  @GET()
  @Produces(MediaType.APPLICATION_JSON)
  public final itemVendor[] listitemVendor() {
    final itemVendor[] itemvendor = itemVendorFactory.showMenu();
    return itemvendor;
  }
   /**
   * @return the connection object.
   * call the data base connection.
   * @param emailId to initialize VendorEmailId.
   * @param pwd to initialize Pwd.
   */
  @GET()
  @Path("/itemvendorlogin/{vendorEmailID}/{pwd}")
  @Produces(MediaType.APPLICATION_JSON)
  public final itemVendor[] listitemVendor(@PathParam("vendorEmailID") final String emailId, @PathParam("pwd") final String pwd) {
    final itemVendor[] itemvendor = itemVendorFactory.loginitemvendor(emailId, pwd);
    return itemvendor;
  }
  /**
   * Returns itemVendor details.
   * @param itId to initialize itemVendorID.
   * @param itName to initialize VendorName.
   * @param phNo to initialize VendorPhoneno.
   * @param emailId to initialize VendorEmailID.
   * @param pwd to initialize Pwd.
   * @return itemvendor signup
   */
  @POST
   @Path("/itemvendorsignup/{itemVendorID}/{vendorName}/{vendorPhoneno}/{vendorEmailID}/{pwd}")
   @Produces(MediaType.APPLICATION_JSON)
   public final String listitemVendor(@PathParam("itemVendorID") final int itId, @PathParam("vendorName") final String itName,
                                      @PathParam("vendorPhoneno") final long phNo, @PathParam("vendorEmailID") final String emailId,
                                      @PathParam("pwd") final String pwd) {
    itemVendorFactory.signup(itId, itName, phNo, emailId, pwd);
    return "Successful Signup";
  }
  /**
   * @return the connection object.
   * call the data base connection.
   * @param phNo to initialize VendorPhoneno.
   * @param emailId to initialize itemVendorID.
   */
  @PUT()
  @Path("/itemvendorupdatePhone/{vendorPhoneno}/{vendorEmailID}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String updatephNo(@PathParam("vendorPhoneno") final long phNo, @PathParam("vendorEmailID") final String emailId) {
    itemVendorFactory.phupdate(phNo, emailId);
    return "Phone Number updated successfully";
  }
  /**
   * @return the connection object.
   * call the data base connection.
   * @param emailId to initialize VendorEmailId.
   * @param phNo to initialize VendorPhoneno.
   */
  @PUT()
  @Path("/itemvendorupdateEmailId/{vendorEmailID}/{vendorPhoneno}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String updateEid(@PathParam("vendorEmailID") final String emailId, @PathParam("vendorPhoneno") final long phNo) {
    itemVendorFactory.eiupdate(emailId, phNo);
    return "Email Id updated successfully";
  }
  /**
   * @return the connection object.
   * call the data base connection.
   * @param pwd to initialize Pwd.
   * @param phNo to initialize VendorPhoneno.
   */
  @PUT()
  @Path("/itemvendorupdatePassword/{pwd}/{vendorPhoneno}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String updatepwd(@PathParam("pwd") final String pwd, @PathParam("vendorPhoneno") final long phNo) {
    itemVendorFactory.pwdupdate(pwd, phNo);
    return "Password updated successfully";
  }
  /**
   * @return the connection object.
   * call the data base connection.
   * @param emailId to initialize VendorEmailId.
   * @param pwd to initialize Pwd.
   */
  @PUT()
  @Path("/itemvendorupdateForgetPwd/{pwd}/{vendorEmailID}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String updateforpass(@PathParam("pwd") final String pwd, @PathParam("vendorEmailID") final String emailId) {
    itemVendorFactory.pwdforpass(pwd, emailId);
    return "Password updated successfully";
  }
  /**
   * @return the connection object.
   * call the data base connection.
   * @param emailId to initialize VendorEmailId.
   * @param pwd to initialize Pwd.
   */
  @DELETE()
  @Path("/itemvendordeleteaccount/{vendorEmailID}/{pwd}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String deleteAcc(@PathParam("vendorEmailID") final String emailId, @PathParam("pwd") final String pwd) {
    itemVendorFactory.accdelete(emailId, pwd);
    return "Your Account has been deleted";
  }
}

