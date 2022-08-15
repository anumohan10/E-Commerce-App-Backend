package com.home.PRO123.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.home.PRO123.model.Customer;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * CustomerDAO class used to fetch data from data base.
 */
public interface CustomerDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Customer")
    @Mapper(CustomerMapper.class)
    List<Customer> show();
    /**
     * @param cEid to initialize Cust email id.
     * @param pwd to initialize passwrd.
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Customer where CustEmailId =:custEmailid AND Passwrd = :passwrd")
    @Mapper(CustomerMapper.class)
    List<Customer> show(@Bind("custEmailid") String cEid, @Bind("passwrd") String pwd);
    /**
     * @param cId to initialize Cust id.
     * @param cName to initialize Cust name.
     * @param cPhno  to initialize Cust phone no.
     * @param cEid to initialize Cust email id.
     * @param pwd to initialize passwrd.
     * @param cAdd to initialize custAddress.
     */
  @SqlUpdate("insert into Customer (CustId, CustName, CustPhNo, CustEmailId, Passwrd, custAddress) "
      + " values (:custId, :custName, :custPhno, :custEmailid, :passwrd, :custAddress)")
    void custSignup(@Bind("custId") int cId, @Bind("custName") String cName, @Bind("custPhno") long cPhno,
      @Bind("custEmailid") String cEid, @Bind("passwrd") String pwd, @Bind("custAddress") String cAdd);
  /**
   * @param cPhno  to initialize Cust phone no.
   * @param cEid to initialize Cust email id.
   */
  @SqlUpdate("update Customer set CustPhNo = :custPhno where CustEmailId = :custEmailid")
  void updatePhno(@Bind("custPhno") long cPhno, @Bind("custEmailid") String cEid);
  /**
   * @param cEid  to initialize Cust phone no.
   * @param cId to initialize Cust email id.
   */
  @SqlUpdate("update Customer set CustEmailId = :custEmailid where CustId = :custId")
  void updateEid(@Bind("custEmailid") String cEid, @Bind("custId") int cId);
  /**
   * @param pwd  to initialize Cust password.
   * @param cEid to initialize Cust email id.
   */
  @SqlUpdate("update Customer set Passwrd = :passwrd where CustEmailId = :custEmailid")
  void updatePwd(@Bind("passwrd") String pwd, @Bind("custEmailid") String cEid);
  /**
   * @param cAdd  to initialize Cust Address.
   * @param cEid to initialize Cust email id.
   */
  @SqlUpdate("update Customer set custAddress = :custAddress where CustEmailId = :custEmailid")
  void updateAdd(@Bind("custAddress") String cAdd, @Bind("custEmailid") String cEid);
  /**
   * @param cEid to initialize Cust email id.
   * @param pwd  to initialize Cust password.
   */
  @SqlUpdate("delete from Customer where CustEmailId = :custEmailid AND Passwrd = :passwrd")
  void deleteAcc(@Bind("custEmailid") String cEid, @Bind("passwrd") String pwd);
}
