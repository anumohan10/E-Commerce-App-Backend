package com.home.PRO123.factory;

import com.home.PRO123.persistence.CustomerDAO;
import com.home.PRO123.persistence.DbConnection;
import java.util.List;

import com.home.PRO123.model.Customer;

public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  protected CustomerFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of cust object.
   * @param cId to initialize Cust id.
   * @param cName to initialize Cust name.
   * @param cPhno  to initialize Cust phone no.
   * @param cEid to initialize Cust email id.
   * @param pwd to initialize passwrd.
   * @param cAdd to initialize custAddress.
   */
  public static String signup(final int cId, final String cName, final long cPhno, final String cEid,
      final String pwd, final String cAdd) {
    dao().custSignup(cId, cName, cPhno, cEid, pwd, cAdd);
    return "Successful Sign Up";
  }
  /**
   * Call the data base connection.
   * @param cEid to initialize Cust email id.
   * @param pwd to initialize passwrd.
   * @return the connection object.
   */
  public static Customer[] loginCust(final String cEid, final String pwd) {
    List<Customer> cust = dao().show(cEid, pwd);
    return cust.toArray(new Customer[cust.size()]);
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param cPhno  to initialize Cust phone no.
   * @param cEid to initialize Cust email id.
   */
  public static String phupdate(final long cPhno, final String cEid) {
    dao().updatePhno(cPhno, cEid);
    return "Successfully Updated Phone Number";
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param cEid  to initialize Cust email id.
   * @param cId to initialize Cust id.
   */
  public static String eiupdate(final String cEid, final int cId) {
    dao().updateEid(cEid, cId);
    return "Successfully Updated Email Id";
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param pwd  to initialize Cust password.
   * @param cEid to initialize Cust email id.
   */
  public static String pwdupdate(final String pwd, final String cEid) {
    dao().updatePwd(pwd, cEid);
    return "Successfully Updated Password";
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param cAdd  to initialize Cust Address.
   * @param cEid to initialize Cust email id.
   */
  public static String addupdate(final String cAdd, final String cEid) {
    dao().updateAdd(cAdd, cEid);
    return "Successfully Updated Address";
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param cEid  to initialize Cust email id.
   * @param pwd to initialize Cust password.
   */
  public static String accdelete(final String cEid, final String pwd) {
    dao().deleteAcc(cEid, pwd);
    return "Your Account has been Deleted";
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  public static Customer[] showMenu() {
    List<Customer> cust = dao().show();
    return cust.toArray(new Customer[cust.size()]);
  }
}
