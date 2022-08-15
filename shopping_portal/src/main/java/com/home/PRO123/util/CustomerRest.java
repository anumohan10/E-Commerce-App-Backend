package com.home.PRO123.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.model.Customer;
import com.home.PRO123.factory.CustomerFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns Customer details.
   * @return the Customer details
   */
  @GET()
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer[] listCustomer() {
    final Customer[] cust = CustomerFactory.showMenu();
    return cust;
  }
  /**
   * Call the data base connection.
   * @param cEid to initialize Cust email id.
   * @param pwd to initialize passwrd.
   * @return the connection object.
   */
  @GET()
  @Path("/customerlogin/{custEmailid}/{passwrd}")
  @Produces(MediaType.APPLICATION_JSON)
  //curl -vvv http://localhost:8080/MLP290/api/customer/customerlogin
  public final Customer[] listCustomer(@PathParam("custEmailid") final String cEid, @PathParam("passwrd") final String pwd) {
    String enpwd = CliMain.encrypt(pwd);
    final Customer[] cust = CustomerFactory.loginCust(cEid, enpwd);
    return cust;
  }
  /**
   * Returns Customer details.
   * @param cName to initialize Cust name.
   * @param cPhno  to initialize Cust phone no.
   * @param cEid to initialize Cust email id.
   * @param pwd to initialize passwrd.
   * @param cAdd to initialize custAddress.
   * @return cust signup.
   */
  @POST()
  @Path("/customersignup/{custName}/{custPhno}/{custEmailid}/{passwrd}/{custAddress}")
  @Produces(MediaType.APPLICATION_JSON)
  //curl -vvv http://localhost:8080/MLP290/api/customer/customersignup
  public final String listCustomer(@PathParam("custName") final String cName, @PathParam("custPhno") final long cPhno,
                                  @PathParam("custEmailid") final String cEid, @PathParam("passwrd") final String pwd,
                                  @PathParam("custAddress") final String cAdd) {
    int cId = 0;
    Customer[] cust = CustomerFactory.showMenu();
    for (Customer c : cust) {
      cId = c.getcustId();
    }
    cId++;
    String strPhno = Long.toString(cPhno);
    int i = strPhno.length();
    int j = pwd.length();
    if (i == 10 && cEid.contains("@") && cEid.contains(".") && j >= 8 && pwd.matches("^[a-zA-Z0-9]*$")) {
      String enpwd = CliMain.encrypt(pwd);
      CustomerFactory.signup(cId, cName, cPhno, cEid, enpwd, cAdd);
      String subject = "Welcome to Cravings";
      String text = "Hey " + cName + " Happy to have you in Cravings. We Hope to fulfil the right craving at the right time.";
      CliMain.sendMail(cEid, subject, text);
      return " Successfully Signed Up";
    } else {
      return " Please enter valid details";
    }
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param pwd  to initialize Cust password.
   * @param cEid to initialize Cust email id.
   */
  @PUT()
   @Path("/forgetpassword/{custEmailid}/{passwrd}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/customer/customerupdatePassword
   public final String forgetpwdcust(@PathParam("custEmailid") final String cEid, @PathParam("passwrd") final String pwd) {
    if (pwd.matches("^[a-zA-Z0-9]*$")) {
      String enpwd = CliMain.encrypt(pwd);
      CustomerFactory.pwdupdate(enpwd, cEid);
      String subject = "Password Updated";
      String text = "Hey user your password has been updated successfully.";
      CliMain.sendMail(cEid, subject, text);
      return " Updated Password of Customer";
    } else {
      return " Invalid Password entered";
    }
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param cPhno  to initialize Cust phone no.
   * @param cEid to initialize Cust email id.
   */
  @PUT()
   @Path("/customerupdatePhone/{custPhno}/{custEmailid}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/customer/customerupdatePhone
   public final String updateCustPhNo(@PathParam("custPhno") final long cPhno, @PathParam("custEmailid") final String cEid) {
    String strPhno = Long.toString(cPhno);
    int i = strPhno.length();
    if (i == 10) {
      CustomerFactory.phupdate(cPhno, cEid);
      String subject = "Phone Number Updated";
      String text = "Hey user your Phone Number has been updated successfully.";
      CliMain.sendMail(cEid, subject, text);
      return " Phone number updated";
    } else {
      return " Invalid Phone number";
    }
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param cEid  to initialize Cust email id.
   * @param cId to initialize Cust id.
   */
  @PUT()
   @Path("/customerupdateEmailId/{custEmailid}/{custId}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/customer/customerupdateEmailId
   public final String updateCustEid(@PathParam("custEmailid") final String cEid, @PathParam("custId") final int cId) {
    if (cEid.contains("@") && cEid.contains(".")) {
      CustomerFactory.eiupdate(cEid, cId);
      String subject = "Email Id Changed";
      String text = "Hey user your Email Id linked to this account is changed successfully.";
      CliMain.sendMail(cEid, subject, text);
      return " Email id Updated";
    } else {
      return " Invalid Email Id";
    }
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param pwd  to initialize Cust password.
   * @param cEid to initialize Cust email id.
   */
  @PUT()
   @Path("/customerupdatePassword/{passwrd}/{custEmailid}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/customer/customerupdatePassword
   public final String updateCustpwd(@PathParam("passwrd") final String pwd, @PathParam("custEmailid") final String cEid) {
    if (pwd.matches("^[a-zA-Z0-9]*$")) {
      String enpwd = CliMain.encrypt(pwd);
      CustomerFactory.pwdupdate(enpwd, cEid);
      String subject = "Password Updated";
      String text = "Hey user your password has been updated successfully.";
      CliMain.sendMail(cEid, subject, text);
      return " Updated Password of Customer";
    } else {
      return " Invalid Password";
    }
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param cAdd  to initialize Cust Address.
   * @param cEid to initialize Cust email id.
   */
  @PUT()
   @Path("/customerupdateAddress/{custAddress}/{custEmailid}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/customer/customerupdateAddress
   public final String updateCustAddress(@PathParam("custAddress") final String cAdd, @PathParam("custEmailid") final String cEid) {
    CustomerFactory.addupdate(cAdd, cEid);
    String subject = "Address Updated";
    String text = "Hey user your Address has been updated successfully.";
    CliMain.sendMail(cEid, subject, text);
    return " Updated Address of Customer";
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param cEid  to initialize Cust email id.
   * @param pwd to initialize Cust password.
   */
  @DELETE()
   @Path("/customerdeleteAccount/{custEmailid}/{passwrd}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/customer/customerdeleteAccount
   public final String deleteCustAcc(@PathParam("custEmailid") final String cEid, @PathParam("passwrd") final String pwd) {
    String enpwd = CliMain.encrypt(pwd);
    CustomerFactory.accdelete(cEid, enpwd);
    String subject = "Account Deactivation";
    String text = "Hey user your account has been deactivated, Hope to see you soon again in Cravings !.";
    CliMain.sendMail(cEid, subject, text);
    return " Delete Customer Account";
  }
}
