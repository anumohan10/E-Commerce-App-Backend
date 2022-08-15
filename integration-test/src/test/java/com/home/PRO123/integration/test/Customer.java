package com.home.PRO123.integration.test;
import java.util.Objects;
import com.hexaware.MLP290.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * cust class used to display cust information.
 * @author hexware
 */
public class Customer {
/**
 * custId to store custId.
 */
  private int custId;
  /**
 * custName to store custName.
 */
  private String custName;
  /**
 * custPhno  to store custPhno.
 */
  private long custPhno;
  /**
 * custEmailid to store custEmailid.
 */
  private String custEmailid;
  /**
 * passwrd to store passwrd.
 */
  private String passwrd;
  /**
 * custAddress to store custAddress.
 */
  private String custAddress;
  /**
   * Default Constructor.
   */
  public Customer() {

  }
/**
 * @param argcustId to initialize Cust id.
 * @param argcustName to initialize Cust name.
 * @param argcustPhno  to initialize Cust phone no.
 * @param argcustEmailid to initialize Cust email id.
 * @param argpasswrd to initialize passwrd.
 * @param argcustAddress to initialize custAddress.
 * used to get details through constructor.
 */

  public Customer(final int argcustId, final String argcustName, final long argcustPhno, final String argcustEmailid,
       final String argpasswrd, final String argcustAddress) {
    this.custId = argcustId;
    this.custName = argcustName;
    this.custPhno = argcustPhno;
    this.custEmailid = argcustEmailid;
    this.passwrd = argpasswrd;
    this.custAddress = argcustAddress;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer cust = (Customer) obj;
    if (Objects.equals(custId, cust.custId) && Objects.equals(custName, cust.custName)
          && Objects.equals(custPhno, cust.custPhno) && Objects.equals(custEmailid, cust.custEmailid)
          && Objects.equals(passwrd, cust.passwrd) && Objects.equals(custAddress, cust.custAddress)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(custId, custName, custPhno, custEmailid, passwrd, custAddress);
  }
    /**
     * @return this Cust ID.
     */
  public final int getcustId() {
    return custId;
  }
  /**
     * @return this Cust name.
     */
  public final String getcustName() {
    return custName;
  }
  /**
     * @return this Cust phone no.
     */
  public final long getcustPhno() {
    return custPhno;
  }
  /**
     * @return this Cust Email Id.
     */
  public final String getcustEmailid() {
    return custEmailid;
  }
  /**
     * @return this passwrd.
     */
  public final String getpasswrd() {
    return passwrd;
  }
  /**
     * @return this Cust Address.
     */
  public final String getcustAddress() {
    return custAddress;
  }
    /**
     * @return this Cust id.
     * @param argcustId to initialize Cust id.
     */
  public final int setcustId(final int argcustId) {
    this.custId = argcustId;
    return argcustId;
  }
  /**
   * @return this Cust name.
     * @param argcustName to initialize Cust name.
     */
  public final String setcustName(final String argcustName) {
    this.custName = argcustName;
    return argcustName;
  }
  /**
   * @return this Cust Phone no.
     * @param argcustPhno  to initialize Cust Phone no.
     */
  public final long setcustPhno(final long argcustPhno) {
    this.custPhno  = argcustPhno;
    return argcustPhno;
  }
  /**
   * @return this email id.
     * @param argcustEmailid to initialize email id.
     */
  public final String setcustEmailid(final String argcustEmailid) {
    this.custEmailid = argcustEmailid;
    return argcustEmailid;
  }
  /**
   * @return this passwrd.
     * @param argpasswrd to initialize passwrd.
     */
  public final String setpasswrd(final String argpasswrd) {
    this.passwrd = argpasswrd;
    return argpasswrd;
  }
  /**
   * @return this custAddress.
     * @param argcustAddress to initialize custAddress.
     */
  public final String setcustAddress(final String argcustAddress) {
    this.custAddress = argcustAddress;
    return argcustAddress;
  }
}
